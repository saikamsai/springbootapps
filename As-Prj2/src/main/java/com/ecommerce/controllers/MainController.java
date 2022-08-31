package com.ecommerce.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.beans.Quote;
import com.ecommerce.demo.AsPrj2Application;

@Controller
public class MainController {

	private static final Logger log = LoggerFactory.getLogger(AsPrj2Application.class);

	@RequestMapping("/")
	@ResponseBody
	public String index() {

		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);

		return quote.toString();
	}

}
