package com.sample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quiz")

public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quizId;

	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", Title=" + Title + ", Subject=" + Subject + ", question=" + question + "]";
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	private String Title;
	private String Subject;

	@ManyToOne
	@JoinColumn(name = "questionId")
	private Question question;

}
