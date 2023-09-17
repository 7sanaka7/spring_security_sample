package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.LoginUser;

@Controller
public class LoginController {
	
	@GetMapping("/loginForm")
	public String getLogin() {
		return"loginForm";
	}
	
	 @GetMapping("/home")
	    public String getHome(Model model, @AuthenticationPrincipal LoginUser loginUser) {
	        model.addAttribute("user", loginUser.getUser());
	        return "home";
	    }

}
