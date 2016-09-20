package edu.mum.ea.project.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.ea.project.model.Beneficiaries;
import edu.mum.ea.project.model.Project;
import edu.mum.ea.project.model.Resource;
import edu.mum.ea.project.model.Status;
import edu.mum.ea.project.model.Task;
import edu.mum.ea.project.service.ProjectService;


@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value={"/"})
	public String main(Model model){
		setDashboardModel(model);
		return "dashboard";
	}
	
	@RequestMapping(value="/projectsAdd")
	public String open(Model model){
		Project p = new Project();
		p.setStatus(Status.PENDING);
		model.addAttribute("project", p);
		return "addProject";
	}
	
	@RequestMapping(value="/projectsAdd", method=RequestMethod.POST)
	public String add(Project project, Model model){
		projectService.save(project);
		setDashboardModel(model);
		return "dashboard";
	}
	
	@RequestMapping(value="/projects/addTask", method=RequestMethod.POST)
	public String addTask(Project project, Task task, Model model){
		project.addTask(task);
		setDashboardModel(model);
		return "dashboard";
	}
	
	@RequestMapping(value="/projectsAddBeneficiary", method=RequestMethod.POST)
	public String addBeneficiary(Project project, Beneficiaries b, Model model){
		project.addBeneficiary(b);
		setDashboardModel(model);
		return "dashboard";
	}
	@RequestMapping(value="/task/addResource", method=RequestMethod.POST)
	public String addResource(Task t ,Resource r, Model model){
		t.setResources(Arrays.asList(r));
		setDashboardModel(model);
		return "dashboard";
	}
	
	private void setDashboardModel(Model model){
		model.addAttribute("projectList", projectService.getProjects());
	}
}