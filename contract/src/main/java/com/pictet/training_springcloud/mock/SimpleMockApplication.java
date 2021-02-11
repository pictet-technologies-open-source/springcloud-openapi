package com.pictet.training_springcloud.mock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Used to load stubs from generated sources
 */
@SpringBootApplication
public class SimpleMockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleMockApplication.class, args);
    }
}
