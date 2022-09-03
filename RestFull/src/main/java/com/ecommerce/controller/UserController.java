package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.userservice.exceptions.UserNotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userrepo;

	@GetMapping
	public Iterable<User> findAllUsers() {
		return userrepo.findAll();

	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Long id) {
		Optional<User> user = userrepo.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException(id);
		}
		return user.get();
	}

	@PostMapping
	public User saveUser(@Validated @RequestBody User user) {
		return userrepo.save(user);
	}

	@PutMapping
	public User update(@RequestBody User user) {
		return userrepo.save(user);
	}

	@DeleteMapping("/{id}")

	public void delete(@PathVariable("id") Long id) {
		userrepo.deleteById(id);
	}

}
