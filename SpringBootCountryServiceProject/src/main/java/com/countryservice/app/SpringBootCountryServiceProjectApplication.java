package com.countryservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.countryservice")
public class SpringBootCountryServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCountryServiceProjectApplication.class, args);
	}

}
