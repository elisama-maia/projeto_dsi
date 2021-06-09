package com.aula;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Employees;
import com.model.EmployeesService;

@Controller
@ComponentScan("com.model")
public class EmployeesController {	
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/addemployee")
	public String formEmployees(Model model) {
		model.addAttribute("employee", new Employees());
		return "adicionarempregado";
	}
	
	@PostMapping("/addemployee")
	public String postEmployees(@ModelAttribute Employees employ, Model model) {
		model.addAttribute("employ",employ);
		model.addAttribute("titulo", "EMPREGADO CADASTRADO COM SUCESSO!");
		EmployeesService es = context.getBean(EmployeesService.class);
		es.insertEmployees(employ);
		return "employeesucess";
	}
	
	@GetMapping("employ/{cd_employee}")
    public String read(@PathVariable("cd_employee") int cd_employee, Model model){
		EmployeesService edao = context.getBean(EmployeesService.class);
		Map<String,Object> employee = edao.getEmployee(cd_employee);
		Employees employ = new Employees((int)employee.get("cd_project"),(String)employee.get("nm_employee"));
		model.addAttribute("employ",employ);
		model.addAttribute("titulo", "DESCRIÇÃO DO EMPREGADO CADASTRADO" + cd_employee);
		return "employeesucess";
    }
	
	@GetMapping("/addemployees")
	public String listar(Model model) {
		EmployeesService edao = context.getBean(EmployeesService.class);
		List<Map<String,Object>> employees = edao.getEmployees();
		model.addAttribute("employees",employees);
		return "gerenciarempregado";
	}
	
	@PostMapping("/apagar/employ/{cd_employee}")
	public String deletar(@PathVariable("cd_employee") int cd_employee,Model model) {
		EmployeesService edao = context.getBean(EmployeesService.class);
		edao.deleteEmployee(cd_employee);
		return "redirect:/addemployees";
	}
}
