package com.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectsDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void insertProjects(Projects project) {
		String sql = "INSERT INTO projects(nm_project,ds_project,dt_start,dt_end)" +
					 " VALUES (?,?,?,?)";
		Object[] obj = new Object[4];
		obj[0] = project.getNm_project();
		obj[1] = project.getDs_project();
		obj[2] = project.getDt_start();
		obj[3] = project.getDt_end();
		jdbc.update(sql, obj);
	}
}
