package com.cg.jpademo.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.cg.jpademo.dto.Employee;

public interface EmployeeDao {
	public Employee saveEmployee(Employee employee);
	public List<Employee> findAll();
	public Employee removeEmployee (BigInteger empId);
	public Employee findEmployee(BigInteger empId);
	public List<Employee> findSalaryList(BigDecimal min, BigDecimal max);
	
}
