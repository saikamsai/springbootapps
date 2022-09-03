package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Answers;

@Repository
public interface AnswerRepository extends JpaRepository<Answers, Integer> {

}
