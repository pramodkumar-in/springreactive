package com.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * @author pramod
 * 
 * */

@SpringBootApplication
@EnableReactiveMongoRepositories
public class SpringreactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringreactiveApplication.class, args);
	}

}
