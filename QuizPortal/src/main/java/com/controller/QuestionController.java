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
import com.entity.Question;
import com.entity.Quiz;
import com.entity.User;

@RestController
@RequestMapping("/admin/quest")
public class QuestionController {

	@Autowired
	private QuestionsService service;

	@GetMapping
	public List<Question> getAllQuestion() {
		return service.getAllQuestion();

	}
	
	
	@PostMapping
	public ResponseEntity<Question> addQuestion(@RequestBody Question que) {
		Question question = service.addQuestion(que);
		if (question != null)
			return new ResponseEntity<Question>(question, HttpStatus.CREATED);
		else
			return new ResponseEntity<Question>(question, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping
	public ResponseEntity<Question> updateQuestion(@RequestBody Question que) {
		Question question = service.updateQuestion(que);
		if (question != null)
			return new ResponseEntity<Question>(question, HttpStatus.OK);
		else
			return new ResponseEntity<Question>(question, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteQuestion(@PathVariable int id) {

		if (service.deleteQuestion(id))
			return new ResponseEntity<Object>("Question is Deleted", HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Unable to do requested service", HttpStatus.NOT_FOUND);
	}

	@PostMapping("/createquiz")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz qu) {
		Quiz quiz = service.addQuiz(qu);
		if (quiz != null)
			return new ResponseEntity<Quiz>(quiz, HttpStatus.CREATED);
		else
			return new ResponseEntity<Quiz>(quiz, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}