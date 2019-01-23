package com.otc.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.otc")
public class OTCApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OTCApiApplication.class, args);
	}
}
