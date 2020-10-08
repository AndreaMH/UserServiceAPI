package com.example.userserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApiApplication.class, args);
	}

}
