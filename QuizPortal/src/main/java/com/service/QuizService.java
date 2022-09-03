package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Quiz;
import com.repository.Quizrepository;

@Service
public class QuizService<questionsid> {

	@Autowired
	private Quizrepository repo;

	public List<Quiz> findque(int quizid) {
		List<Quiz> questionss = repo.findByQuizid(quizid);
		return questionss;
	}

	public List<Quiz> getAllQuizes() {
		List<Quiz> quizes = repo.findAll();
		return quizes;
	}

}