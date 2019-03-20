package com.main.springbootstart.service;

import java.util.List;

import com.main.springbootstart.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee employee);
	
	public void deleteById(int id);
}
