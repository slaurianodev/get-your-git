package br.com.sergio.controller;

import br.com.sergio.client.api.GitHubServiceImpl;
import br.com.sergio.client.mapping.GitHubLogin;
import br.com.sergio.client.mapping.GitHubRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetYourGitController {

    private static final Logger log = LoggerFactory.getLogger(GetYourGitController.class);

    @PostMapping("/login")
    public GitHubLogin login(@RequestParam Map<String,String> login) {
        log.info("login: "+login.toString());
        GitHubServiceImpl service = new GitHubServiceImpl();
        return service.login(login.get("inputLogin"), login.get("inputPassword"));
    }

    @GetMapping("/repos")
    public List<GitHubRepo> repos(@RequestParam String repoUrl) {
        GitHubServiceImpl service = new GitHubServiceImpl();
        return service.repositories(repoUrl);
    }

}
