package com.main.springbootstart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.springbootstart.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	@Override
	public List<Employee> findAll() {
		//create query
		Query query=entityManager.createQuery("from Employee");
		//execute; get result
		List<Employee>employees=query.getResultList();
		//return
		return employees;
	}

	@Override
	public Employee findById(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public void save(Employee parameterEmployee) {
		Employee employee=entityManager.merge(parameterEmployee);
		parameterEmployee.setId(employee.getId());
	}

	@Override
	public void deleteById(int id) {
		Query query=entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}

}
