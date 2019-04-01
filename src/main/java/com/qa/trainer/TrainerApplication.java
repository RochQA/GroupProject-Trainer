package com.qa.trainer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TrainerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainerApplication.class, args);
	}

}
