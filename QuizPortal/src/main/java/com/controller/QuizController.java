package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Question;
import com.entity.Quiz;
import com.repository.QuestionRepository;
import com.service.QuizService;

@RestController
@RequestMapping("user")

public class QuizController {

	@Autowired
	private QuizService service;

	@Autowired
	private QuestionRepository qurepo;

	@GetMapping("/{quizid}")
	public ResponseEntity<Object> findque(@PathVariable int quizid) {
		// getting all the questions data attached with the given quiz id
		List<Quiz> resp = service.findque(quizid);
		System.out.println(resp);

		// created an arraylist to store which questions comes under the given quiz id
		ArrayList<Integer> questionid = new ArrayList<Integer>();

		// saveing all the question id's in the arraylist
		resp.forEach(e -> questionid.add(e.getQuestionid()));
		System.out.println(questionid);

		// findinal all the questions with the given question ids
		List<Question> findall = qurepo.findAllById(questionid);
		ArrayList<String> question = new ArrayList<String>();

		// storing all the questions and their options in the new arraylist
		findall.forEach((e) -> {
			question.add("Que. " + e.getA_ques());
			question.add("(a) " + e.getOptA());
			question.add("(b) " + e.getOptB());
			question.add("(c) " + e.getOptC());
			question.add("(d) " + e.getOptD());
			question.add("_____________________");

		});

		System.out.println(question);

		if (questionid.size() != 0)
			return new ResponseEntity<Object>(question, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Quiz not Available", HttpStatus.NOT_FOUND);
	}
}