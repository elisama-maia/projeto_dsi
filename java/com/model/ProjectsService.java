package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsService {
	
	@Autowired
	ProjectsDAO pdao;
	
	public void insertProjects(Projects p) {
		pdao.insertProjects(p);
	}
}
