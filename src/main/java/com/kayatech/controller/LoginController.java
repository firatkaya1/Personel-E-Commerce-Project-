package com.kayatech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class LoginController {

	
	@GetMapping(value = "/login")
	public String index() {
		return "/login";
	}
	
	@PostMapping(value = "/login")
	public String index(@RequestParam("username") String username,@RequestParam("password") String password) {
		System.out.println("Username : "+username);
		System.out.println("Password :"+password);
		return "/main";
	}
	
	
	
}
