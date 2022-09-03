package com.sample.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sample.entity.Question;

public interface QuestionRepository extends CrudRepository<Question ,Integer>{
	

}
