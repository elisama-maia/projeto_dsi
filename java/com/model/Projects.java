package com.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Projects {
	
	private int cd_project;
	private String nm_project;
	private String ds_project;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dt_start;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dt_end;
	
	public Projects() {}
	
	public Projects(String nm_project, String ds_project, Date dt_start, Date dt_end) {
		this.nm_project = nm_project;
		this.ds_project = ds_project;
		this.dt_start = dt_start;
		this.dt_end = dt_end;
	}
	
	public Projects(int cd_project, String nm_project, String ds_project, Date dt_start, Date dt_end) {
		this.cd_project = cd_project;
		this.nm_project = nm_project;
		this.ds_project = ds_project;
		this.dt_start = dt_start;
		this.dt_end = dt_end;
	}

	public int getCd_project() {
		return cd_project;
	}

	public void setCd_project(int cd_project) {
		this.cd_project = cd_project;
	}

	public String getNm_project() {
		return nm_project;
	}

	public void setNm_project(String nm_project) {
		this.nm_project = nm_project;
	}

	public String getDs_project() {
		return ds_project;
	}

	public void setDs_project(String ds_project) {
		this.ds_project = ds_project;
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
}
