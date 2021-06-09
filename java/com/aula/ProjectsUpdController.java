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

import com.model.Tasks;
import com.model.TasksService;

@Controller
public class ProjectsUpdController {

	@Autowired
	private ApplicationContext context;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	
	@GetMapping("/upd/task/{cd_task}")
    public String updateForm(@PathVariable("cd_task") int cd_task, Model model){
		TasksService tdao = context.getBean(TasksService.class);
		Map<String,Object> antigo = tdao.getTask(cd_task);
		Tasks task = new Tasks((int)antigo.get("cd_project"),(int)antigo.get("cd_employee"),(String)antigo.get("nm_project"),(String)antigo.get("ds_project"),(Date)antigo.get("dt_start"),(Date)antigo.get("dt_end"),(String)antigo.get("ds_status"),(String)antigo.get("ds_priority"));
		model.addAttribute("antigo",task);
		model.addAttribute("cd_task",cd_task);
		return "formtaskupd";
    }
	
	@PostMapping("/upd/task/{cd_task}")
	public String update(@PathVariable("cd_task") int cd_task,@ModelAttribute Tasks tas, Model model) {
		TasksService tdao = context.getBean(TasksService.class);
		tdao.updateTask(cd_task, tas);
		return "redirect:/addtasks";
	}
}
