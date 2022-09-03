package com.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository repo;

	@GetMapping
	public Iterable<Product> getProducts() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") Integer id) {
		Optional<Product> optProduct = repo.findById(id);
		if (optProduct.isEmpty()) {
			throw new ProductNotFoundException(id);
		}
		return optProduct.get();
	}

	

}