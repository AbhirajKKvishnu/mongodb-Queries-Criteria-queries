package com.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mongo")
public class MongoQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoQueryApplication.class, args);
	}

}
