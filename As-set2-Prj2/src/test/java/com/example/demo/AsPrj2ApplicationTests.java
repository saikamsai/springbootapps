package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class AsPrj2ApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void contextLoads() {
		assertThat(restTemplate).isNotNull();
	}

}
