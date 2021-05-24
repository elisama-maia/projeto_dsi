package com.aula;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.PathVariable;
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
	public String postProjects(@ModelAttribute Projects proj, Model model) {
		model.addAttribute("proj",proj);
		model.addAttribute("titulo", "PROJETO CADASTRADO COM SUCESSO!");
		ProjectsService ps = context.getBean(ProjectsService.class);
		ps.insertProjects(proj);
		return "projectsucess";
	}
	
	@GetMapping("descr/{cd_project}")
    public String read(@PathVariable("cd_project") int cd_project, Model model){
		ProjectsService pdao = context.getBean(ProjectsService.class);
		Map<String,Object> project = pdao.getProject(cd_project);
		Projects proj = new Projects((String)project.get("nm_project"),(String)project.get("ds_project"),
						(Date)project.get("dt_start"),(Date)project.get("dt_end"));
		model.addAttribute("proj",proj);
		model.addAttribute("titulo", "DESCRIÇÃO DO PROJETO CADASTRADO" + cd_project);
		return "projectsucess";
    }
	
	@GetMapping("/addprojects")
	public String listar(Model model) {
		ProjectsService pdao = context.getBean(ProjectsService.class);
		List<Map<String,Object>> projects = pdao.getProjects();
		model.addAttribute("projects",projects);
		return "gerenciar";
	}
	
	@PostMapping("/apagar/{cd_project}")
	public String deletar(@PathVariable("cd_project") int cd_project,Model model) {
		ProjectsService pdao = context.getBean(ProjectsService.class);
		pdao.deleteProject(cd_project);
		return "redirect:/addprojects";
	}
}
