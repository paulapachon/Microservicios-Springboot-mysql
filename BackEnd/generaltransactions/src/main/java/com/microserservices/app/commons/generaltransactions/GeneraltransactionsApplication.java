package com.microserservices.app.commons.generaltransactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GeneraltransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneraltransactionsApplication.class, args);
	}

}
