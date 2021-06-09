package com.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

public class Tasks {
	
	@Id
	private int cd_task;
	private int cd_project, cd_employee;
	private String nm_task;
	private String ds_task;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dt_start;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dt_end;
	private String ds_status;
	private String ds_priority;
	
	public Tasks() {}

	public Tasks(int cd_project, int cd_employee, String nm_task, String ds_task, Date dt_start,
			Date dt_end, String ds_status, String ds_priority) {
		this.cd_project = cd_project;
		this.cd_employee = cd_employee;
		this.nm_task = nm_task;
		this.ds_task = ds_task;
		this.dt_start = dt_start;
		this.dt_end = dt_end;
		this.ds_status = ds_status;
		this.ds_priority = ds_priority;
	}
	public Tasks(int cd_task, int cd_project, int cd_employee, String nm_task, String ds_task, Date dt_start,
			Date dt_end, String ds_status, String ds_priority) {
		this.cd_task = cd_task;
		this.cd_project = cd_project;
		this.cd_employee = cd_employee;
		this.nm_task = nm_task;
		this.ds_task = ds_task;
		this.dt_start = dt_start;
		this.dt_end = dt_end;
		this.ds_status = ds_status;
		this.ds_priority = ds_priority;
	}

	public int getCd_task() {
		return cd_task;
	}

	public void setCd_task(int cd_task) {
		this.cd_task = cd_task;
	}

	public String getNm_task() {
		return nm_task;
	}

	public void setNm_task(String nm_task) {
		this.nm_task = nm_task;
	}

	public String getDs_task() {
		return ds_task;
	}

	public void setDs_task(String ds_task) {
		this.ds_task = ds_task;
	}

	public Date getDt_start() {
		return dt_start;
	}

	public void setDt_start(Date dt_start) {
		this.dt_start = dt_start;
	}

	public Date getDt_end() {
		return dt_end;
	}

	public void setDt_end(Date dt_end) {
		this.dt_end = dt_end;
	}

	public String getDs_status() {
		return ds_status;
	}

	public void setDs_status(String ds_status) {
		this.ds_status = ds_status;
	}

	public String getDs_priority() {
		return ds_priority;
	}

	public void setDs_priority(String ds_priority) {
		this.ds_priority = ds_priority;
	}

	public int getCd_project() {
		return cd_project;
	}

	public void setCd_project(int cd_project) {
		this.cd_project = cd_project;
	}

	public int getCd_employee() {
		return cd_employee;
	}

	public void setCd_employee(int cd_employee) {
		this.cd_employee = cd_employee;
	}
}
