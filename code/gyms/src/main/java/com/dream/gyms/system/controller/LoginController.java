package com.dream.gyms.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/LoginController")
public class LoginController {

	@RequestMapping(value="/login")
	public String login(String param){
		
		return "index";
	}
	
	@RequestMapping(value="/demo")
	public String demo(String param){
		
		return "demo";
	}
}
