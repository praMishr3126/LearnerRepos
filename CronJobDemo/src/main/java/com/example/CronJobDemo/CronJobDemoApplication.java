package com.example.CronJobDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CronJobDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CronJobDemoApplication.class, args);
	}

}
