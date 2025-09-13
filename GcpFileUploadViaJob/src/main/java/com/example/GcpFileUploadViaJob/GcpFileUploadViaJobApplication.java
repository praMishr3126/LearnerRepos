package com.example.GcpFileUploadViaJob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {
com.google.cloud.spring.autoconfigure.parametermanager.GcpParameterManagerAutoConfiguration.class
})
@EnableScheduling
public class GcpFileUploadViaJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcpFileUploadViaJobApplication.class, args);
	}

}
