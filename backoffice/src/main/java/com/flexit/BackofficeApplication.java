package com.flexit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EntityScan(basePackages = {"com.flexit.commons.entities", "com.flexit.commons.dto"})
@SpringBootApplication(scanBasePackages = {"com.flexit.commons.*", "com.flexit.backoffice.*"})
public class BackofficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackofficeApplication.class, args);
    }

}
