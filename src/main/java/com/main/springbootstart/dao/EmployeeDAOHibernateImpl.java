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

	// entity manager
	private EntityManager entityManager;

	// constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// get hibernate session
		Session session = entityManager.unwrap(Session.class);
		// create query
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		// execute, get resultList, and return
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int id) {
		// get hibernate session
		Session session = entityManager.unwrap(Session.class);
		// get and return employee
		return session.get(Employee.class, id);
	}

	@Override
	public void save(Employee employee) {
		// get session
		Session session = entityManager.unwrap(Session.class);
		// save employee
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		// get session
		Session session = entityManager.unwrap(Session.class);
		// delete
		Query query = session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}

}
