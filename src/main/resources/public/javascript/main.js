$(function(){
    $('#login-form').submit(function() {
        $.ajax({
            type: 'POST',
            url: "/login",
            data: $('#login-form').serialize(),
            success: function(json) {
                result=JSON.stringify(json);
                sessionStorage.setItem('login_data',result);
                window.location.replace("/repositories.html");
            },
            error:function(json) {
                result=JSON.stringify(json);
                response=JSON.parse(result);
                responseText=JSON.parse(response['responseText']);
                alert('Status: ' + response['statusText'] + ' Message: '+responseText['message']);
            }
        })
        return false;
    });
});

function fill_repo_data(){
    login = JSON.parse(sessionStorage.getItem('login_data'));
    img_attributes = $('<img src=\"'+login['avatar_url']+'\" class=\"img-rounded\" alt=\"Rounded Image\">');
    login_name = $('<h2>'+login['name']+'</h2>');
    login_user = $('<p><b>'+login['login']+'<b></p>');
    $('#avatar').append(img_attributes);
    $('#user-name').append(login_name,login_user);
    $('#user-name').append(login_user);

    repos = JSON.parse(sessionStorage.getItem('repos_data'));

    for(i=0; i < repos.length; i++){
        name = repos[i]['name'];
        link = repos[i]['html_url'];
        description = repos[i]['description'];
        language = repos[i]['language'];

        repo_info = $(`<tr><td><a href='${link}'>${name}</a></td><td>${description}</td><td>${language}</td></tr>`);
        $('#tb-repos-body').append(repo_info);
    }
}

 function get_repos_data(){
        login_json = JSON.parse(sessionStorage.getItem('login_data'));
        $.ajax({
            type: 'GET',
            url: '/repos?repoUrl='+login_json['repos_url'],
            success: function(json) {
                result=JSON.stringify(json);
                sessionStorage.setItem('repos_data',result);
                fill_repo_data();
            },
            error:function(json) {
                 result=JSON.stringify(json);
                 response=JSON.parse(result);
                 responseText=JSON.parse(response['responseText']);
                 alert('Status: ' + response['statusText'] + ' Message: '+responseText['message']);
            }
        })
        return false;
}

function get_creator_data(){
    $.ajax({
                type: 'GET',
                url: '/creator',
                success: function(json) {
                    result=JSON.stringify(json);
                    sessionStorage.setItem('creator_data',result);
                    fill_creator_data();
                },
                error:function(json) {
                    result=JSON.stringify(json);
                    console.log("NOK "+result);
                }
            })
            return false;
}

function fill_creator_data(){
    creator_info = JSON.parse(sessionStorage.getItem('creator_data'));
    creator_user = creator_info['login'];
    creator_link = creator_info['link'];
    creator_source = creator_info['source'];

    creator_footer = $(`<div class='footer-copyright text-center py-3'>Created by <a href='${creator_link}' >${creator_user}</a>, source code: <a href='${creator_source}'>here</a></div>`);
    $('#creator-info').append(creator_footer);
}

function logout(){
    sessionStorage.clear();
    window.location.replace("/login.html");
}