package com.project.swisscomtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SwisscomTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwisscomTaskApplication.class, args);
	}

}
