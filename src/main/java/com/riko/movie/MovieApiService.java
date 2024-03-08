package com.riko.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MovieApiService {

	public static void main(String[] args) {
		SpringApplication.run(MovieApiService.class, args);
	}

}
