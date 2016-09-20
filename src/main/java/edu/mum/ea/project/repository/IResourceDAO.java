package edu.mum.ea.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.ea.project.model.Resource;

public interface IResourceDAO extends JpaRepository<Resource, Integer>{
	public Resource saveAndFlush(Resource arg0);
	List<Resource> findAll();
}