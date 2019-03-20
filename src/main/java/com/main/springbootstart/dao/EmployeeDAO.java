package com.main.springbootstart.dao;

import java.util.List;

import com.main.springbootstart.entity.Employee;

public interface EmployeeDAO {
	public List<Employee>findAll();
	
}
