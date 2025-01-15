package com.githubmoore.challenge_foro_hub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.githubmoore.challenge_foro_hub")
public class ChallengeForoHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeForoHubApplication.class, args);
    }
}