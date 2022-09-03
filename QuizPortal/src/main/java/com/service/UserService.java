package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Login;
import com.entity.User;
import com.repository.LoginRepository;
import com.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private LoginRepository urepo;

	public List<Login> getAllUsers() {
		return urepo.findAll();
	}
}