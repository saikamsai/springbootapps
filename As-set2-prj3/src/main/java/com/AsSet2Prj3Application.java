package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class AsSet2Prj3Application {

	public static void main(String[] args) {
		SpringApplication.run(AsSet2Prj3Application.class, args);
	}

}
