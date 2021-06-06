package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksService {
	
	@Autowired
	TasksDAO tdao;
	
	public void insertTasks(Tasks t) {
		tdao.insertTasks(t);
	}
	
	public Map<String, Object> getTask(int cd_task) {
		 return tdao.getTask(cd_task);
	}
	  
	public List<Map<String, Object>> getTasks() {
	     return tdao.getTasks();
	}
	  
	public void deleteTask(int cd_task) {
		 tdao.deleteTask(cd_task);
	}
	  
	public void updateTask(int cd_task, Tasks task) {
		 tdao.updateTask(cd_task, task);
	}
}
