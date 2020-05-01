package com.almenoscompila.ApplicationBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationBackendApplication {

	@Autowired
	UserDAO userdao;

	public static void main(String[] args) {
		SpringApplication.run(ApplicationBackendApplication.class, args);
	}

}
