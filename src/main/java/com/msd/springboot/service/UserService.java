package com.msd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msd.springboot.model.User;
import com.msd.springboot.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
	    
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public User findByUsernameAndPassword(String username, String password) {

           return userRepository.findByUsernameAndPassword(username,password);
	}

}
