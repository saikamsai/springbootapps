
package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.entity.EProduct;

public interface EProductRepository extends CrudRepository<EProduct, Integer>{
	List<EProduct> findByName(String name);
	
	List<EProduct> findByPrice(Double price);
	
	List<EProduct> findByNameAndPrice(String name, Double price);
	

}