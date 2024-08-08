package com.example.runners;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.runners.run.Location;
import com.example.runners.run.Run;
import com.example.runners.run.RunRepository;

@SpringBootApplication
public class RunnersApplication {
	private static final Logger log = LoggerFactory.getLogger(RunnersApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnersApplication.class, args);
		log.info("Hello Maven!");
	}

	@Bean
	CommandLineRunner runner(RunRepository runRepository) {
		return args -> {
			Run run = new Run(1, "Hello", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 8,
					Location.OUTDOOR);
			log.info("Run: " + run);
			log.info("Run Avg: " + run.getAvgPace());
			// runRepository.create(run);
		};
	}
}
