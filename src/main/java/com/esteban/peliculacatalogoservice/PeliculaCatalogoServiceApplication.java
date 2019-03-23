package com.esteban.peliculacatalogoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PeliculaCatalogoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeliculaCatalogoServiceApplication.class, args);
	}

}
