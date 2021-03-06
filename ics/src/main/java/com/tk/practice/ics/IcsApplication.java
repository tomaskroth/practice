package com.tk.practice.ics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class IcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcsApplication.class, args);
	}

}
