package com.aula;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Projects;
import com.model.ProjectsService;

@Controller
@ComponentScan("com.model")
public class ProjectsController {	
	
	@Autowired
	private ApplicationContext context;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	
	@GetMapping("/addproject")
	public String formProjects(Model model) {
		model.addAttribute("project", new Projects());
		return "criar";
	}
	
	@PostMapping("/addproject")
	public String postProjects(@ModelAttribute Projects pro,
								Model model) {
		ProjectsService ps = context.getBean(ProjectsService.class);
		ps.insertProjects(pro);
		return "sucesso";
	}
}
