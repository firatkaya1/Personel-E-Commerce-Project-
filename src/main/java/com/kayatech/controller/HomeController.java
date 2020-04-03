package com.kayatech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping(value = "/index")
	public String index() {
		return "/index";
	}
	
	@GetMapping(value = "/contact")
	public String contact(Model model) {
		return "/contact";
	}
	@PostMapping(value = "/contact")
	public String contact() {
		return "/contact";
	}
	
	@GetMapping(value = "/products")
	public String products(Model model) {
		return "/products";
	}
	@PostMapping(value = "/products")
	public String products() {
		return "/products";
	}
	
	@GetMapping(value = "/products/forms")
	public String forms(Model model) {
		return "/forms";
	}
	
	@GetMapping(value = "/team")
	public String team(Model model) {
		return "/team";
	}
	@PostMapping(value = "/team")
	public String team() {
		return "/team";
	}
	
	@GetMapping(value = "/blog")
	public String blog(Model model) {
		return "/blog";
	}
	@PostMapping(value = "/blog")
	public String blog() {
		return "/blog";
	}
	
	@GetMapping(value = "/product/forms/buy")
	public String buy(Model model) {
		return "/buy";
	}
	@PostMapping(value = "/product/forms/buy")
	public String buy() {
		return "/buy";
	}
	
}
