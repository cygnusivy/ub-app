package com.urbtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
@ComponentScan(basePackages = "com.urbtech.config")
public class UrbtechApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(UrbtechApiApplication.class, args);
	}

}