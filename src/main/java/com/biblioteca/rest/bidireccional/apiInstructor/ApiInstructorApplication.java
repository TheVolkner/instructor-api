package com.biblioteca.rest.bidireccional.apiInstructor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ApiInstructorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiInstructorApplication.class, args);
	}

}
