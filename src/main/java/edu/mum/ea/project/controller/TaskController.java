package edu.mum.ea.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cs544.extra.domain.Task;
import cs544.extra.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService tService;
	
	@RequestMapping(value="/tasks")
	public String openTasksPage(Model model, @RequestParam("projectId") int projectId){
		model.addAttribute("taskList", tService.getTasks(projectId));
		model.addAttribute("task", new Task());
		return "tasks";
	}
	
	@RequestMapping(value="/tasks", method=RequestMethod.POST)
	public String saveTask(Model model, Task task, @RequestParam("projectId") int projectId){
		tService.save(task, projectId);
		return openTasksPage(model, projectId);
	}
}