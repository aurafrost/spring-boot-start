package com.main.springbootstart.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.main.springbootstart.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//entity manager
	private EntityManager entityManager;
	//constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	@Override
	@Transactional
	public List<Employee> findAll() {
		//get hibernate session
		Session session=entityManager.unwrap(Session.class);
		//create query
		Query<Employee>query=session.createQuery("from Employee",Employee.class);
		//execute, get resultList, and return
		List<Employee>employees=query.getResultList();
		return employees;
	}

}
