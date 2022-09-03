package com.sample.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entity.Question;
import com.sample.entity.Quiz;
import com.sample.repository.QuestionRepository;
import com.sample.repository.Quizrepository;

@RestController
@RequestMapping("/admin/quiz")

public class AdminquizController {
	@Autowired
	private Quizrepository qurepo;

	@GetMapping
	public Iterable<Quiz> getAllQuiz() {
		return qurepo.findAll();

	}

	@GetMapping("/{quizId}")
	public Quiz getQuestion(@PathVariable("quizId") Integer quizId) {
		Optional<Quiz> optQu = qurepo.findById(quizId);
//	if (optQues.isEmpty()) {
//		throw new QuestionNotFoundException(questionId);
//	}
		return optQu.get();
	}

	@PostMapping
	public Quiz create(@RequestBody Quiz qu) {
		return qurepo.save(qu);
	}

	@PutMapping
	public Quiz update(@RequestBody Quiz qu) {
		return qurepo.save(qu);
	}

	@DeleteMapping("/{quizId}")

	public void delete(@PathVariable("quizId") Integer quizId) {
		qurepo.deleteById(quizId);
	}

}