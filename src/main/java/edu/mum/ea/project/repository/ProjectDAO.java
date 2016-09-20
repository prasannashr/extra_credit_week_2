package edu.mum.ea.project.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ea.project.model.Project;
import edu.mum.ea.project.model.Task;
import edu.mum.ea.project.model.Beneficiaries;

@Repository
@Deprecated
public class ProjectDAO  {

	//@Resource
	private SessionFactory sf;
	
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void addProject(Project p) {
		sf.getCurrentSession().persist(p);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void editProject(Project p) {
		sf.getCurrentSession().merge(p);
	}

	public void addTask(Project p, Task t) {
		p.addTask(t);
	}

	public void addBeneficiary(Project p, Beneficiaries b) {
		p.addBeneficiary(b);
	}

}