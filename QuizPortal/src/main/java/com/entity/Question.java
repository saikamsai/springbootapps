package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String a_ques;
	private String optA;
	private String optB;
	private String optC;
	private String optD;
	private String answer;

	@Override
	public String toString() {
		return "Question [id=" + id + ", a_ques=" + a_ques + ", optA=" + optA + ", optB=" + optB + ", optC=" + optC
				+ ", optD=" + optD + ", q_ans=" + ", answer=" + answer + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getA_ques() {
		return a_ques;
	}

	public void setA_ques(String a_ques) {
		this.a_ques = a_ques;
	}

	public String getOptA() {
		return optA;
	}

	public void setOptA(String optA) {
		this.optA = optA;
	}

	public String getOptB() {
		return optB;
	}

	public void setOptB(String optB) {
		this.optB = optB;
	}

	public String getOptC() {
		return optC;
	}

	public void setOptC(String optC) {
		this.optC = optC;
	}

	public String getOptD() {
		return optD;
	}

	public void setOptD(String optD) {
		this.optD = optD;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
