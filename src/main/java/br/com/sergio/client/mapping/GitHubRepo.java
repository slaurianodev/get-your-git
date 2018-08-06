package br.com.sergio.client.mapping;

public class GitHubRepo {
    private String name;
    private String html_url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    @Override
    public String toString(){
        return String.format("GitHubRepo:[name:%s,htmlUrl:%s]",name,html_url);
    }
}
