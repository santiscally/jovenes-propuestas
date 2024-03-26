package com.jovenes.propuestas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
public class JovenesPropuestasApplication {

	public static void main(String[] args) {
		SpringApplication.run(JovenesPropuestasApplication.class, args);
	}

}
