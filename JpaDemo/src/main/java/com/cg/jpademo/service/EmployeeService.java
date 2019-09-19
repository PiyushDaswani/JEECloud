package com.cg.jpademo.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.cg.jpademo.dto.Employee;
import com.cg.jpademo.exception.EmployeeException;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	public List<Employee> findAll();
	public Employee removeEmployee (BigInteger empId) throws EmployeeException;
	public Employee findEmployee(BigInteger empId);
	public Employee updateEmployee(Employee employee) throws EmployeeException;
	public List<Employee> findSalaryList(BigDecimal min, BigDecimal max);
	
}
