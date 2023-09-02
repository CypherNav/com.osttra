package com.osttra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/Registeration_page")
	public String Registeration_page() {
		return "Registeration_page";
	}
}
