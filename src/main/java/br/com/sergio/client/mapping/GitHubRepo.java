package br.com.sergio.client.mapping;

public class GitHubRepo {
    private String name;
    private String html_url;
    private String description;
    private String language;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return String.format("GitHubRepo:[name:%s,htmlUrl:%s,description:%s,language:%s]", name, html_url,description,language);
    }
}
