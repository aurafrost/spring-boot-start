package com.main.springbootstart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.springbootstart.entity.Employee;
import com.main.springbootstart.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;

	// inject service
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// read
	// expose and return list of employees
	@GetMapping("/")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	//read single
	@GetMapping("/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee=employeeService.findById(employeeId);
		if(employee==null)
			throw new RuntimeException("Employee not found with id "+employeeId);
		return employee;
	}
	
	//create
	@PostMapping("/")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}
	
	//update
	@PutMapping("/")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	//delete
	@DeleteMapping("/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee=employeeService.findById(employeeId);
		if(employee==null) {
			throw new RuntimeException("Employee not found with id "+employeeId);
		}
		employeeService.deleteById(employeeId);
		return "Deleted employee with id "+employeeId;
	}
}
