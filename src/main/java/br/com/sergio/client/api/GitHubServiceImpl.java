package br.com.sergio.client.api;

import br.com.sergio.client.mapping.GitHubLogin;
import br.com.sergio.client.mapping.GitHubRepo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class GitHubServiceImpl implements IGitHubService{
    @Override
    public GitHubLogin login(String user, String password) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(user,password));
        GitHubLogin login = restTemplate.getForObject("https://api.github.com/user", GitHubLogin.class);

        return login;
    }

    @Override
    public List<GitHubRepo> repositories(String reposUrl) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<GitHubRepo>> response = restTemplate.exchange(
                reposUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<GitHubRepo>>(){});
        return response.getBody();
    }
}
