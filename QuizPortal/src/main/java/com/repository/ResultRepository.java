package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {



}
