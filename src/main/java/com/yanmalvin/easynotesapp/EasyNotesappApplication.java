package com.yanmalvin.easynotesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// populated whenever create or update an entitiy (createdAt&updateAt)
@EnableJpaAuditing
public class EasyNotesappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyNotesappApplication.class, args);
	}

}
