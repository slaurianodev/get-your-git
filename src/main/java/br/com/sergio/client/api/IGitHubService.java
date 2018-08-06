package br.com.sergio.client.api;

import br.com.sergio.client.mapping.GitHubLogin;
import br.com.sergio.client.mapping.GitHubRepo;

import java.util.List;

public interface IGitHubService {
    public GitHubLogin login(String user, String password);
    public List<GitHubRepo> repositories(String reposUrl);
}
