package com.sisco.springjdbc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJdbc1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext config= SpringApplication.run(SpringJdbc1Application.class, args);
		Controller controller= config.getBean(Controller.class);
		controller.save(new Employee(6, "siva", 45000, "MTM"));
		//controller.updateEmp(4, 10000, "MGR");
		//controller.getById(1);
		//controller.getAll();
		//controller.deleteById(4);
	}

}
