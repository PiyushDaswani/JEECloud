package com.cg.jpademo.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.jpademo.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private static EntityManagerFactory entityManagerFactory;
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("jpademo");	
	}

	public EmployeeDaoImpl() {
		super();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(employee);
		tx.commit();
		return employee;
	}

	@Override
	public List<Employee> findAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("FROM Employee");
		@SuppressWarnings("unchecked")
		List<Employee> empList = query.getResultList();
		return empList;
	}
	
	@Override
	public List<Employee> findSalaryList(BigDecimal min, BigDecimal max) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("FROM Employee WHERE empSalary BETWEEN :first AND :second");
		query.setParameter("first", min);
		query.setParameter("second", max);
		@SuppressWarnings("unchecked")
		List<Employee> empList = query.getResultList();
		return empList;
	}

	@Override
	public Employee removeEmployee(BigInteger empId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		Employee emp = entityManager.find(Employee.class, empId);
		if (emp != null) {
			tx.begin();
			entityManager.remove(emp);
			tx.commit();
		}
		return emp;
	}

	@Override
	public Employee findEmployee(BigInteger empId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Employee.class, empId);
	}

}
