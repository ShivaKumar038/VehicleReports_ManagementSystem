package com.msd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.msd.springboot.model.Credentails;
import com.msd.springboot.model.User;
import com.msd.springboot.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/enter")
	public String enterApp() {
		return "register";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute User user) {
		
		
	    user = userService.saveUser(user);
	    if(user == null) {
	    	return "register";
	    }
	    return "login";
		
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute Credentails credentails) {
		String username = credentails.getUsername();
		String password = credentails.getPassword();
		User user = userService.findByUsernameAndPassword(username,password);
		if(!(user == null)) {
			return "home";
		}
		return "register";
	}

}
