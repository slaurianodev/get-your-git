package br.com.sergio.controller;

import br.com.sergio.client.api.GitHubServiceImpl;
import br.com.sergio.client.mapping.GitHubLogin;
import br.com.sergio.client.mapping.GitHubRepo;
import br.com.sergio.service.mapping.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class GetYourGitController {

    private static final Logger log = LoggerFactory.getLogger(GetYourGitController.class);

    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GitHubLogin login(@RequestBody Login login) {
        GitHubServiceImpl service = new GitHubServiceImpl();
        return service.login(login.getLogin(), login.getPassword());
    }

    @RequestMapping(value = "/repos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GitHubRepo> repos(@RequestParam String repoUrl) {
        GitHubServiceImpl service = new GitHubServiceImpl();
        return service.repositories(repoUrl);
    }

}
