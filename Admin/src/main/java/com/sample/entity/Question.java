package com.sample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	private String a_question;
	private String op1;
	private String op2;
	private String op3;
	private String op4;
	private String q_correctAns;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getA_question() {
		return a_question;
	}
	public void setA_question(String a_question) {
		this.a_question = a_question;
	}
	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOp3() {
		return op3;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public String getOp4() {
		return op4;
	}
	public void setOp4(String op4) {
		this.op4 = op4;
	}
	public String getQ_correctAns() {
		return q_correctAns;
	}
	public void setQ_correctAns(String q_correctAns) {
		this.q_correctAns = q_correctAns;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", a_question=" + a_question + ", op1=" + op1 + ", op2=" + op2
				+ ", op3=" + op3 + ", op4=" + op4 + ", q_correctAns=" + q_correctAns + "]";
	}

	
}
