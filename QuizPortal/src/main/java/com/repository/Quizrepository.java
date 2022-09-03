package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Quiz;


@Repository
public interface Quizrepository extends JpaRepository<Quiz, Integer> {
	
	public List<Quiz>findByQuizid(int quizid);

}
