package com.project.badminton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	//index.html로 이동하는 컨트롤러
	@GetMapping()
	public String index() {
		return "/index";
	}
}
