package com.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeesDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void insertEmployees(Employees employee) {
		String sql = "INSERT INTO employees(nm_employee)" +
					 " VALUES (?)";
		Object[] obj = new Object[1];
		obj[0] = employee.getNm_employee();
		jdbc.update(sql, obj);
	}
	
	public Map<String, Object> getEmployee(int cd_employee) {
    	String sql = "SELECT * FROM employees WHERE employees.cd_employee = ?";
    	Object[] obj = new Object[1];
    	obj[0] = cd_employee;
    	return jdbc.queryForMap(sql,obj);
    }
    
    public List<Map<String, Object>> getEmployees() {
    	String sql = "SELECT * FROM employees";
    	List<Map<String, Object>> employees = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return employees;
    }
    
    public void deleteEmployee(int cd_employee) {
        String sql = "DELETE FROM employees WHERE cd_employee = ?" ;
        jdbc.update(sql, new Object[] {cd_employee});
    }
    
    public void updateEmployee(int cd_employee,Employees employ) {
    	String sql = "UPDATE employees SET nm_employee = ? WHERE cd_employee = ?";
    	 jdbc.update(sql, new Object[]{
         		employ.getNm_employee(), cd_employee
         });
    }
}
