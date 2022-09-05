package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class AsSet2Prj5Application {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(AsSet2Prj5Application.class, args);
	}

	@KafkaListener(topics = "ecommerce", groupId = "group-id")
	public void listen(String message) {
		System.out.println("Received Message in group - group-id: " + message);
	}

}
