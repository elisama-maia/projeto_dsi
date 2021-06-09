package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsService {

	
	@Autowired
	ProjectsDAO pdao;
	
	public void insertProjects(Projects p) {
		pdao.insertProjects(p);
	}
	
	public Map<String, Object> getProject(int cd_project) {
		 return pdao.getProject(cd_project);
	}
	  
	public List<Map<String, Object>> getProjects() {
	     return pdao.getProjects();
	}
	  
	public void deleteProject(int cd_project) {
		 pdao.deleteProject(cd_project);
	}
	  
	public void updateProject(int cd_project, Projects proj) {
		 pdao.updateProject(cd_project, proj);
	}
}
