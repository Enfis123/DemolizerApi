package com.enfis.DemolizerApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication()
public class DemolizerApiApplication implements CommandLineRunner {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemolizerApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Este código se ejecutará al inicio de la aplicación
		System.out.println("MongoDB connection test:");
		System.out.println("Database name: " + mongoTemplate.getDb().getName());
		System.out.println("Collection names: " + mongoTemplate.getCollectionNames());
		System.out.println("MongoDB connection successful!");
	}
}