package com.service;

import org.springframework.data.domain.Sort;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Answers;
import com.entity.Question;
import com.entity.Quiz;
import com.entity.Result;
import com.entity.User;
import com.repository.QuestionRepository;
import com.repository.Quizrepository;
import com.repository.ResultRepository;

@Service
public class QuestionsService {

	@Autowired
	private QuestionRepository quesrepo;

	@Autowired
	private Quizrepository quizrepo;
	
	@Autowired
	ResultRepository rRepo;
	

	public List<Question> getAllQuestion() {
		return quesrepo.findAll();
	}
	public Question getQuestionById(int id) {
		if (quesrepo.findById(id).isPresent())
			return quesrepo.findById(id).get();
		else
			return null;
	}
	
	public Question addQuestion(Question que) {
		return quesrepo.save(que);
	}

	

	public Question updateQuestion(Question que) {
		return quesrepo.save(que);
	}

	
	
	public boolean deleteQuestion(int id) {

		if (quesrepo.findById(id).isPresent()) {
			quesrepo.deleteById(id);
			return true;
		} else
			return false;
	}
	
	public List<Result> gethighestScore() {
		List<Result> sList = rRepo.findAll(Sort.by(Sort.Direction.DESC, "correct"));
		return sList;
	}
	
	public List<Result> getAllResults() {
		return rRepo.findAll();
	}

	// quiz creation
	public Quiz addQuiz(Quiz que) {
		return quizrepo.save(que);
	}
	
	
}
