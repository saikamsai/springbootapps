package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Answers;
import com.entity.Question;
import com.entity.Quiz;
import com.entity.Result;
import com.repository.AnswerRepository;
import com.repository.QuestionRepository;
import com.repository.ResultRepository;
import com.service.QuizService;

@RestController
@RequestMapping("/user/ans")
public class AnswerController {
	@Autowired
	private AnswerRepository Arepo;

	@Autowired
	private QuizService Qservice;
	@Autowired
	private QuestionRepository Qrepo;
	

	@Autowired
	private ResultRepository repo;

	int quizid;
	int count = 0;
	String Name;
	
	ArrayList<String> finalresult = new ArrayList<String>();
	

	@PostMapping
	public ResponseEntity<Object> addAnswers(@RequestBody Answers a) {
		Answers answer = Arepo.save(a);
		quizid = answer.getQuizid();
		Name=answer.getName();
		
		if (answer != null) {
			ArrayList<String> userans = new ArrayList<String>();
			userans.add(answer.getAns1());
			userans.add(answer.getAns2());
			userans.add(answer.getAns3());

			List<Quiz> resp = Qservice.findque(quizid);

			// created an arraylist to store which questions comes under the given quiz id
			ArrayList<Integer> questionsid = new ArrayList<Integer>();

			// saving all the qid's in the arraylist
			resp.forEach(e -> questionsid.add(e.getQuestionid()));
			System.out.println(questionsid);

			List<Question> findall = Qrepo.findAllById(questionsid);
			ArrayList<String> ans = new ArrayList<String>();
			findall.forEach((e) -> ans.add(e.getAnswer()));
			for (int i = 0; i < ans.size(); i++) {
				if (ans.get(i).equalsIgnoreCase(userans.get(i))) {
					count++;
					

				}
			}
			
			finalresult.clear();
			finalresult.add( "Participant Name: "+Name+"    "+"Quiz Id: "+ quizid+"Score: " +count + " Out of " + questionsid.size());
			
			finalresult.add("Correct Ans: " + ans);
			System.out.println(ans);
			count = 0;
			
		}
		
		return new ResponseEntity<Object>(finalresult, HttpStatus.CREATED);

	}
	

	
}