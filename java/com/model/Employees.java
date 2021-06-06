package com.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;


public class Employees {
	
	@Id
	private int cd_employee;
	private String nm_employee;
	
	@MappedCollection(keyColumn = "cd_employee", idColumn = "cd_employee")
	private Set<Tasks> tasks;
	
	public Employees() {}
	
	public Employees(String nm_employee) {
		this.nm_employee = nm_employee;
	}

	public Employees(int cd_employee, String nm_employee) {
		this.cd_employee = cd_employee;
		this.nm_employee = nm_employee;
	}

	public int getCd_employee() {
		return cd_employee;
	}

	public void setCd_employee(int cd_employee) {
		this.cd_employee = cd_employee;
	}

	public String getNm_employee() {
		return nm_employee;
	}

	public void setNm_employee(String nm_employee) {
		this.nm_employee = nm_employee;
	}
}	
