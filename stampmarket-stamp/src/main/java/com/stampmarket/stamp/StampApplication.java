package com.stampmarket.stamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
public class StampApplication {
    public static void main(String[] args) {
        SpringApplication.run(StampApplication.class, args);
    }
}
