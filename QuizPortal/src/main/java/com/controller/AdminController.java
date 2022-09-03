package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.QuestionsService;
import com.service.QuizService;
import com.service.UserService;
import com.entity.Login;
import com.entity.Question;
import com.entity.Quiz;
import com.entity.Result;
import com.entity.User;
import com.repository.AdminRepository;
import com.repository.AnswerRepository;
import com.repository.QuestionRepository;
import com.repository.Quizrepository;
import com.repository.ResultRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AnswerRepository Arepo;
	
	@Autowired
	AdminRepository Adminrepo;
	@Autowired
	private QuestionsService Qservice;
	
	@Autowired
	private QuizService Qzservice;
	@Autowired
	private QuestionRepository Qrepo;

	@Autowired
	private Quizrepository Qurepo;

	@Autowired
	private ResultRepository repo;
	
	@Autowired
	private UserService uservice;
	
	@Autowired
	QuizService QzService;


	@PostMapping("/login")
	public String loginUser(@RequestBody Login user) {
		List<Login> users = Adminrepo.findAll();

		for (Login other : users) {
			if (other.equals(user) && other.getRole().matches("Admin")) {
				Adminrepo.save(user);
				return "Login Succesfull";
			}
		}

		return "Login failure";
	}//

	@GetMapping("/users")
	public List<Login> getAllUsers() {
		return uservice.getAllUsers();
	}

	@GetMapping("/quizes")
	public List<Quiz> getAllQuizes() {
		return QzService.getAllQuizes();
	}
	
	@GetMapping("/results")
	public List<Result> getAllResults() {
		return Qservice.getAllResults();
	}
	
	@GetMapping("/scores")
	public List<Result> getscores() {
		return Qservice.gethighestScore();
	} 
}//
