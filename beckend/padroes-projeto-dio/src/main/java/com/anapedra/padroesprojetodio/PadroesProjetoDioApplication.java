package com.anapedra.padroesprojetodio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PadroesProjetoDioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesProjetoDioApplication.class, args);
	}

}
