package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Login;
import com.entity.Quiz;
import com.repository.LoginRepository;
import com.service.QuizService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private QuizService Qzservice;
	@Autowired
	LoginRepository loginRepository;

	@PostMapping("register")
	public String registerUser(@RequestBody Login newUser) {
		List<Login> users=loginRepository.findAll();
		System.out.println("New user: " + newUser.toString());

        for (Login user : users) {
            System.out.println("Registered user: " + newUser.toString());

            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return "User with the name already exists";
            }
	}
        loginRepository.save(newUser);
        return "Registered successfully";
	}
	
	@PostMapping("login")
	public String loginUser(@RequestBody Login user) {
		List<Login> users = loginRepository.findAll();

        for (Login other : users) {
            if (other.equals(user)) {
                loginRepository.save(user);
                return "Login Succesfull";
            }
        }

        return "Login failure";
	}
	
	@GetMapping("/quizes")
	public List<Quiz> getAllQuizes() {
		return Qzservice.getAllQuizes();
	}
	
	@PostMapping("logout")
	public String logoutUser(@RequestBody Login user) {
		List<Login> users = loginRepository.findAll();

        for (Login other : users) {
            if (other.equals(user)) {
                loginRepository.save(user);
                return "Logout Succesfull";
            }
        }

        return "Logout failure";
	}
	
}