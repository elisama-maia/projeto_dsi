package com.aula;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
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
public class ProjectsUpdController {

	@Autowired
	private ApplicationContext context;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	
	@GetMapping("/upd/{cd_project}")
    public String updateForm(@PathVariable("cd_project") int cd_project, Model model){
		ProjectsService pdao = context.getBean(ProjectsService.class);
		Map<String,Object> antigo = pdao.getProject(cd_project);
		Projects proj = new Projects((String)antigo.get("nm_project"),(String)antigo.get("ds_project"),(Date)antigo.get("dt_start"),(Date)antigo.get("dt_end"));
		model.addAttribute("antigo",proj);
		model.addAttribute("cd_project",cd_project);
		return "formprojupd";
    }
	
	@PostMapping("/upd/{cd_project}")
	public String update(@PathVariable("cd_project") int cd_project,@ModelAttribute Projects proj, Model model) {
		ProjectsService pdao = context.getBean(ProjectsService.class);
		pdao.updateProject(cd_project, proj);
		return "redirect:/addprojects";
	}
}
