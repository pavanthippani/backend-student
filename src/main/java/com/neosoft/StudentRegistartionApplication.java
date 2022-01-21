package com.neosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StudentRegistartionApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRegistartionApplication.class, args);
	}

}
