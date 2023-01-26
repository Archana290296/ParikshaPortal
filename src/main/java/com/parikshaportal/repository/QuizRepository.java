package com.parikshaportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parikshaportal.model.exam.Category;
import com.parikshaportal.model.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{
	
	public List<Quiz> findByCategory(Category category);
	
	// for user
	
	public List<Quiz> findByActive(Boolean b);
	
	public List<Quiz> findByCategoryAndActive(Category c, Boolean b);

}
