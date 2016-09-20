package edu.mum.ea.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.ea.project.model.Project;


public interface IProjectDAO extends JpaRepository<Project, Integer> {

	public Project saveAndFlush(Project arg0);

	public List<Project> findAll();
	
	public Project findOneById(int id);
}