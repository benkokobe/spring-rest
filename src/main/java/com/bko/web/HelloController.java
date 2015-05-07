package com.bko.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class HelloController {
	@RequestMapping(value = "/hello")
	public String sayHello (Model model){
		model.addAttribute("greeting", "Hello world");
		return "hello";
	}
}
