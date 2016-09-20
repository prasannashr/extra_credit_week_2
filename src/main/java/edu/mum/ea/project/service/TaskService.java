package edu.mum.ea.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ea.project.model.Project;
import edu.mum.ea.project.model.Task;
import edu.mum.ea.project.repository.IProjectDAO;
import edu.mum.ea.project.repository.ITaskDAO;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class TaskService {
	@Autowired
	private ITaskDAO taskDAO;
	
	@Autowired
	private IProjectDAO projectDAO;
	
	public void save(Task t, int projectId){
		Project p = projectDAO.findOne(projectId);
		p.addTask(t);
		projectDAO.save(p);
	}
	
	public List<Task> getTasks(int projectId){
		return taskDAO.findByProject_Id(projectId);
	}
}
