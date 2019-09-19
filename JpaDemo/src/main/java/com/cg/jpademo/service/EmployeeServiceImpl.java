package com.cg.jpademo.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.cg.jpademo.dao.EmployeeDao;
import com.cg.jpademo.dao.EmployeeDaoImpl;
import com.cg.jpademo.dto.Employee;
import com.cg.jpademo.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao dao = new EmployeeDaoImpl();
	
	public EmployeeServiceImpl() {
		super();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return dao.saveEmployee(employee);
	}

	@Override
	public List<Employee> findAll() {
		return dao.findAll();
	}

	@Override
	public Employee removeEmployee(BigInteger empId) throws EmployeeException {
		Employee returnedEmployee = dao.removeEmployee(empId);
		if(returnedEmployee != null) {
			return returnedEmployee;
		}
		throw new EmployeeException("The employee doesnt exist!");
		
	}

	@Override
	public Employee findEmployee(BigInteger empId) {
		return dao.findEmployee(empId);
	}
	
	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		Employee returnedEmployee = dao.removeEmployee(employee.getEmpId());
		if(returnedEmployee == null) {
			throw new EmployeeException("The employee doesnt exist!");
		}
		dao.saveEmployee(employee);
		return employee;
	}

	@Override
	public List<Employee> findSalaryList(BigDecimal min, BigDecimal max) {
		// TODO Auto-generated method stub
		return dao.findSalaryList(min, max);
	}

}
