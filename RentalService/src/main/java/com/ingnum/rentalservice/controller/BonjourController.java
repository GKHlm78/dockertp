package com.ingnum.rentalservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class BonjourController {

        private final RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/bonjour")
    public String bonjour() {
        String prenom = restTemplate.getForObject("http://php-service:80", String.class);
        return "bonjour," + prenom;
    }
}

