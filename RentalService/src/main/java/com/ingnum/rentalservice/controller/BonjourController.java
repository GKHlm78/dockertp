package com.ingnum.rentalservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customer")
public class BonjourController {

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{name}")
    public String bonjour(@PathVariable String name) {
        String prenom = restTemplate.getForObject(customerServiceUrl, String.class);
        return "Bonjour " + name + " (" + prenom + ")";
    }
}


