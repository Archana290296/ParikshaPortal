package com.parikshaportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parikshaportal.model.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
