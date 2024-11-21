package com.sisco.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {
	@Autowired
	private Dao dao;

	public void save(Employee emp) {
		System.out.println("service started.");
		dao.save(emp);
	}

	public void updateEmp(int eid,double esal, String elocation) {
		System.out.println("service started.");
		dao.updateEmp(eid,esal,elocation);
	}

	public void getById(int eid) {
		System.out.println("service started.");
		dao.getById(eid);
	}

	public void getAll() {
		System.out.println("service started.");
		dao.getAll();
	}

	public void deleteById(int eid) {
		System.out.println("service started.");
		dao.deleteById(eid);
	}
		
	}

