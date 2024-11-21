package com.sisco.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {
	@Autowired
	private Service service;

	public void save(Employee emp) {
		System.out.println("Controller is started.");
		service.save(emp);
	}

	public void updateEmp(int eid,double esal, String elocation) {
		System.out.println("Controller is started.");
		service.updateEmp(eid,esal, elocation);
	}

	public void getById(int eid) {
		System.out.println("Controller is started.");
		service.getById(eid);
	}

	public void getAll() {
		System.out.println("Controller is started.");
		service.getAll();
	}

	public void deleteById(int eid) {
		System.out.println("Controller is started.");
		service.deleteById(eid);
	}

}
