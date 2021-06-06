package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeesService {
	
	@Autowired
	EmployeesDAO edao;
	
	public void insertEmployees(Employees e) {
		edao.insertEmployees(e);
	}
	
	public Map<String, Object> getEmployee(int cd_employee) {
		 return edao.getEmployee(cd_employee);
	}
	  
	public List<Map<String, Object>> getEmployees() {
	     return edao.getEmployees();
	}
	  
	public void deleteEmployee(int cd_employee) {
		 edao.deleteEmployee(cd_employee);
	}
	  
	public void updateEmployee(int cd_employee, Employees employ) {
		 edao.updateEmployee(cd_employee, employ);
	}
}
