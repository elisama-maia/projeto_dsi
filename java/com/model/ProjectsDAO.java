package com.model;

import java.util.List;
import java.util.Map;

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
	
	public Map<String, Object> getProject(int cd_project) {
    	String sql = "SELECT * FROM projects WHERE projects.cd_project = ?";
    	Object[] obj = new Object[1];
    	obj[0] = cd_project;
    	return jdbc.queryForMap(sql,obj);
    }
    
    public List<Map<String, Object>> getProjects() {
    	String sql = "SELECT * FROM projects";
    	List<Map<String, Object>> projects = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return projects;
    }
    
    public void deleteProject(int cd_project) {
        String sql = "DELETE FROM projects WHERE cd_project = ?" ;
        jdbc.update(sql, new Object[] {cd_project});
    }
    
    public void updateProject(int cd_project,Projects proj) {
    	String sql = "UPDATE projects SET nm_project = ?, ds_project = ?, dt_start = ?, dt_end = ? WHERE cd_project = ?";
    	 jdbc.update(sql, new Object[]{
         		proj.getNm_project(), proj.getDs_project(), proj.getDt_start(), proj.getDt_end(),cd_project
         });
    }
}
