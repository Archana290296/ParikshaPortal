package com.parikshaportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parikshaportal.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);

}
