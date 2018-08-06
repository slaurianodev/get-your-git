package br.com.sergio.client.mapping;

public class GitHubLogin {
    private String login;
    private String name;
    private String avatar_url;
    private String repos_url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    @Override
    public String toString(){
        return String.format("GitHubLogin:[login:%s,name:%s,avatarUrl:%s,reposUrl:%s]",login,name,avatar_url,repos_url);
    }
}
