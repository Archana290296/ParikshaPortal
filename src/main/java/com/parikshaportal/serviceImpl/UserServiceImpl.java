package com.parikshaportal.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parikshaportal.model.User;
import com.parikshaportal.model.UserRole;
import com.parikshaportal.repository.RoleRepository;
import com.parikshaportal.repository.UserRepository;
import com.parikshaportal.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) {
		
		User local=this.userRepository.findByUsername(user.getUsername());
		
		if(local !=null) {
			System.out.println("User is already there !!");
			throw new IllegalArgumentException("user already present !!");
		}else {
			for(UserRole ur: userRoles)
			{
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local=this.userRepository.save(user);
		}
		return local;
	}

	@Override
	public void deleteUser(Long userId) {
		
		this.userRepository.deleteById(userId);
	}

	@Override
	public User getUser(String Username) {
		
		return this.userRepository.findByUsername(Username);
	}

	
}
