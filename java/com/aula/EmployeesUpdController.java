package com.aula;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Employees;
import com.model.EmployeesService;

@Controller
public class EmployeesUpdController {

	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/upd/employ/{cd_employee}")
    public String updateForm(@PathVariable("cd_employee") int cd_employee, Model model){
		EmployeesService edao = context.getBean(EmployeesService.class);
		Map<String,Object> antigo = edao.getEmployee(cd_employee);
		Employees employ = new Employees((int)antigo.get("cd_project"),(String)antigo.get("nm_employee"));
		model.addAttribute("antigo",employ);
		model.addAttribute("cd_employee",cd_employee);
		return "formemployupd";
    }
	
	@PostMapping("/upd/employ/{cd_employee}")
	public String update(@PathVariable("cd_employee") int cd_employee,@ModelAttribute Employees employ, Model model) {
		EmployeesService edao = context.getBean(EmployeesService.class);
		edao.updateEmployee(cd_employee, employ);
		return "redirect:/addemployees";
	}
}
