package com.main.springbootstart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.springbootstart.dao.EmployeeDAO;
import com.main.springbootstart.entity.Employee;

@RestController
@RequestMapping("/")
public class EmployeeRestController {
	private EmployeeDAO employeeDAO;

	// inject dao
	@Autowired
	public EmployeeRestController(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	// expose and return list of employees
	@GetMapping("/")
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

}
