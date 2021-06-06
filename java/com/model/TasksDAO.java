package com.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TasksDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void insertTasks(Tasks task) {
		String sql = "INSERT INTO tasks(nm_task,ds_task,dt_start,dt_end,ds_status,ds_priority)" +
					 " VALUES (?,?,?,?,?,?)";
		Object[] obj = new Object[6];
		obj[0] = task.getNm_task();
		obj[1] = task.getDs_task();
		obj[2] = task.getDt_start();
		obj[3] = task.getDt_end();
		obj[4] = task.getDs_status();
		obj[5] = task.getDs_priority();
		jdbc.update(sql, obj);
	}
	
	public Map<String, Object> getTask(int cd_task) {
    	String sql = "SELECT * FROM tasks WHERE tasks.cd_task = ?";
    	Object[] obj = new Object[1];
    	obj[0] = cd_task;
    	return jdbc.queryForMap(sql,obj);
    }
    
    public List<Map<String, Object>> getTasks() {
    	String sql = "SELECT * FROM tasks";
    	List<Map<String, Object>> tasks = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return tasks;
    }
    
    public void deleteTask(int cd_task) {
        String sql = "DELETE FROM tasks WHERE cd_task = ?" ;
        jdbc.update(sql, new Object[] {cd_task});
    }
    
    public void updateTask(int cd_task,Tasks task) {
    	String sql = "UPDATE tasks SET nm_task = ?, ds_task = ?, dt_start = ?, dt_end = ?, ds_status = ?, ds_priority = ? WHERE cd_task = ?";
    	 jdbc.update(sql, new Object[]{
    			 task.getNm_task(), task.getDs_task(), task.getDt_start(), task.getDt_end(), task.getDs_status(), task.getDs_priority(),cd_task
         });
    }
}
