package com.aula;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controllers {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/projetos")
	public String projetos() {
		return "projetos";
	}
	
	@GetMapping("/empregados")
	public String empregados() {
		return "empregados";
	}
	
	@GetMapping("/tarefas")
	public String tarefas() {
		return "tarefas";
	}
}
