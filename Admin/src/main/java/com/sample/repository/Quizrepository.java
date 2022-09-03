package com.sample.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.entity.Quiz;

public interface Quizrepository extends CrudRepository<Quiz, Integer> {

}
