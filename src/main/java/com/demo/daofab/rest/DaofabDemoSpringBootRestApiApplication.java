package com.demo.daofab.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // Exclude Spring authentication for test API
public class DaofabDemoSpringBootRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaofabDemoSpringBootRestApiApplication.class, args);
	}

}
