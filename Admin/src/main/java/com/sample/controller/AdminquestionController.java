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
import com.sample.repository.QuestionRepository;

@RestController
@RequestMapping("/admin")
public class AdminquestionController {

	@Autowired
	private QuestionRepository qesrepo;

	@GetMapping
	public Iterable<Question> getAllQuestion() {
		return qesrepo.findAll();

	}

	@GetMapping("/{questionId}")
	public Question getQuestion(@PathVariable("questionId") Integer questionId) {
		Optional<Question> optQues = qesrepo.findById(questionId);
//		if (optQues.isEmpty()) {
//			throw new QuestionNotFoundException(questionId);
//		}
		return optQues.get();
	}

	@PostMapping
	public Question create(@RequestBody Question ques) {
		return qesrepo.save(ques);
	}

	@PutMapping
	public Question update(@RequestBody Question ques) {
		return qesrepo.save(ques);
	}

	@DeleteMapping("/{questionId}")

	public void delete(@PathVariable("questionId") Integer questionId) {
		qesrepo.deleteById(questionId);
	}

}