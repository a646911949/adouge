package com.adouge.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AdougeAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdougeAuthApplication.class, args);
    }

}