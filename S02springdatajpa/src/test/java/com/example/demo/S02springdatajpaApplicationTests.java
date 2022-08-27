package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@SpringBootTest
class S02springdatajpaApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
	}

//	@Test
//	void saveProduct() {
//		ProductRepository repo = context.getBean(ProductRepository.class);
//
//		Product product = new Product();
//		product.setName("laptop");
//		product.setDescription("Lenovo");
//		product.setPrice(4500);
//
//		repo.save(product);
//
//	}

	@Test
	void readProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);
		Optional<Product> optionalProduct = repo.findById(1);
		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			System.out.println(product);
		}
	}

//	@Test
//	void deleteProduct() {
//		ProductRepository repo = context.getBean(ProductRepository.class);
//		repo.deleteById(3);
//		repo.deleteById(4);
//		repo.deleteById(5);
//	}
//
//	@Test
//	void findByName() {
//		ProductRepository repo = context.getBean(ProductRepository.class);
//
//		List<Product> products = repo.findByName("headset");
//		System.out.println(products);
//	}
}