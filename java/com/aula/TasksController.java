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

import com.model.Tasks;
import com.model.TasksService;

@Controller
@ComponentScan("com.model")
public class TasksController {	
	
	@Autowired
	private ApplicationContext context;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	
	@GetMapping("/addtask")
	public String formTasks(Model model) {
		model.addAttribute("task", new Tasks());
		return "adicionartarefa";
	}
	
	@PostMapping("/addtask")
	public String postTasks(@ModelAttribute Tasks task, Model model) {
		model.addAttribute("task",task);
		model.addAttribute("titulo", "TAREFA CADASTRADA COM SUCESSO!");
		TasksService ts = context.getBean(TasksService.class);
		ts.insertTasks(task);
		return "tasksucess";
	}
	
	@GetMapping("task/{cd_task}")
    public String read(@PathVariable("cd_task") int cd_task, Model model){
		TasksService tdao = context.getBean(TasksService.class);
		Map<String,Object> task = tdao.getTask(cd_task);
		Tasks tas = new Tasks((int)task.get("cd_project"),(int)task.get("cd_employee"),(String)task.get("nm_task"),(String)task.get("ds_task"),
				(Date)task.get("dt_start"),(Date)task.get("dt_end"),(String)task.get("ds_status"),(String)task.get("ds_priority"));
		model.addAttribute("tas",tas);
		model.addAttribute("titulo", "DESCRIÇÃO DA TAREFA CADASTRADA" + cd_task);
		return "tasksucess";
    }
	
	@GetMapping("/addtasks")
	public String listar(Model model) {
		TasksService tdao = context.getBean(TasksService.class);
		List<Map<String,Object>> tasks = tdao.getTasks();
		model.addAttribute("tasks",tasks);
		return "gerenciartarefa";
	}
	
	@PostMapping("/apagar/task/{cd_task}")
	public String deletar(@PathVariable("cd_task") int cd_task,Model model) {
		TasksService tdao = context.getBean(TasksService.class);
		tdao.deleteTask(cd_task);
		return "redirect:/addtasks";
	}
}
