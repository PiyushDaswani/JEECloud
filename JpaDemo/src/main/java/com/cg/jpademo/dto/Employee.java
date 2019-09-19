package com.cg.jpademo.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.*;

@Entity
@Table(name = "emp")
public class Employee {

	@Id
	@Column(name = "emp_id")
	private BigInteger empId;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_salary")
	private BigDecimal empSalary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(BigInteger empId, String empName, BigDecimal empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public BigInteger getEmpId() {
		return empId;
	}

	public void setEmpId(BigInteger empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public BigDecimal getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(BigDecimal empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}

}
