package com.parikshaportal.service;

import java.util.Set;

import com.parikshaportal.model.User;
import com.parikshaportal.model.UserRole;

public interface UserService {
	
	public User createUser(User user, Set<UserRole> userRoles);
	public User getUser(String Username);
	public void deleteUser(Long userId);
	

}
