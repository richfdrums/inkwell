package com.richfdrums.inkwell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * Entry point. {@code @SpringBootApplication} = {@code @Configuration}
 * + {@code @EnableAutoConfiguration} + {@code @ComponentScan} of this package and below.
 */
@ConfigurationPropertiesScan
@SpringBootApplication
public class InkwellApplication {

    public static void main(String[] args) {
        SpringApplication.run(InkwellApplication.class, args);
    }
}
