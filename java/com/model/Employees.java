package com.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;


public class Employees {
	
	@Id
	private int cd_employee;
	private int cd_project;
	private String nm_employee;
	
	@MappedCollection(keyColumn = "cd_employee", idColumn = "cd_employee")
	private List<Tasks> tasks;
	
	public Employees() {}
	
	public Employees(int cd_project, String nm_employee) {
		this.cd_project = cd_project;
		this.nm_employee = nm_employee;
	}

	public Employees(int cd_employee, int cd_project, String nm_employee) {
		this.cd_employee = cd_employee;
		this.cd_project = cd_project;
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

	public int getCd_project() {
		return cd_project;
	}

	public void setCd_project(int cd_project) {
		this.cd_project = cd_project;
	}
}	
