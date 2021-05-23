package com.aula;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controllers {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/gerenciar")
	public String empregados() {
		return "gerenciar";
	}
}
