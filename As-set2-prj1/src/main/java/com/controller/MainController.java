package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.EProduct;
import com.exception.ProductNotFoundException;
import com.repository.EProductRepository;


@Controller
@RestController
@RequestMapping("/products")
public class MainController {
	
	@Autowired
	private EProductRepository repo;


	@GetMapping("/{id}")
	public EProduct getEProduct(@PathVariable("id") int id) {
		Optional<EProduct> optProduct = repo.findById(id);
		if (optProduct.isEmpty()) {
			throw new ProductNotFoundException(id);
		}
		return optProduct.get();
	}
}
