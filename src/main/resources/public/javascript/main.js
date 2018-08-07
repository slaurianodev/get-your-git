var url_service_login = "http://localhost:8080/login";
var url_service_repos = "http://localhost:8080/repos";
var login_github_data=null;
var list_repos = null;

function do_request(obj,url,method,func){
	var req = new XMLHttpRequest();

	req.open(method, url, true);
	req.setRequestHeader("Content-Type","application/json");

	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			res=JSON.parse(this.responseText);
			func(res);
		}
	};
	req.send(obj);

}



function do_login(login,password){
    var obj = "{\"login\":\""+login+"\",\"password\":\""+password+"\"}";
    var res=do_request(obj,url_service_login,"POST",function(res){login_github_data = res; console.log(login_github_data);} );
    localStorage.setItem('login_data',login_github_data);
}

function do_repos(){
    if(login_github_data != null){
        console.log("url_repo: "+login_github_data['repos_url']);
        var res=do_request(null,url_service_repos+"?repoUrl"+login_github_data['url_repo'],"GET",function(res){list_repos = res; console.log(list_repos);});
    }
}

function send_user_login(){
        login = '';
        password='';

        form = $('#login-form').serializeArray();
        for(i=0; i < form.length; i++){
        	if(form[i]['name'] == 'inputLogin'){
        		login =form[i]['value'];
        	}
        	if(form[i]['name'] == 'inputPassword'){
                password =form[i]['value'];
            }
        }
        console.log('login: '+login);
        console.log('password: '+password);

        if(login != '' && password != ''){
            var obj = "{\"inputLogin\":\""+login+"\",\"inputPassword\":\""+password+"\"}";
            console.log(obj);
            return obj;
        }
}

$(function(){
    $('#login-form').submit(function() {
        $.ajax({
            type: 'POST',
            url: "/login",
            data: $('#login-form').serialize(),
            success: function(json) {
                res=JSON.stringify(json);
                localStorage.setItem('login_data',res);
                console.log("OK "+res);
            },
            error:function(json) {
                res=JSON.stringify(json);
                console.log("NOK "+res);
            }
        })
        return false;
    });
});


