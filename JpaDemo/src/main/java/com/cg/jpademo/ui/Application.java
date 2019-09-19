package com.cg.jpademo.ui;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

import com.cg.jpademo.dto.Employee;
import com.cg.jpademo.exception.EmployeeException;
import com.cg.jpademo.service.EmployeeService;
import com.cg.jpademo.service.EmployeeServiceImpl;

public class Application {

	public static EmployeeService service = new EmployeeServiceImpl();
	public static Scanner sc =new Scanner(System.in);
	
	public Application() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		int x;
		System.out.println("Choose what you wanna do");
		System.out.println("1. Enter an Employee");
		System.out.println("2. Delete an Employee");
		System.out.println("3. Update an Employee");
		System.out.println("4. Show all emp");
		System.out.println("5. Find an Employee");
		System.out.println("6. Show employees within specific salary range");
		System.out.println("0. Exit");
		x = sc.nextInt();
		while(x >=1)
		{
			switch(x){
				case 1:
					System.out.println("Enter Id");
					BigInteger id = sc.nextBigInteger();
					System.out.println("Enter the name");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.println("Enter the salary");
					BigDecimal sal = sc.nextBigDecimal();
					Employee emp = new Employee(id,name,sal);
					service.saveEmployee(emp);
					System.out.println("Employee was added");
					break;
				case 2:
					System.out.println("Enter Id to be removed");
					BigInteger id1 = sc.nextBigInteger();
					try {
						Employee deletedEmployee = service.removeEmployee(id1);
						System.out.println("Employee was deleted !" + deletedEmployee);
					} catch (EmployeeException e) {
						System.err.println(e.getMessage());
					}
					break;
				case 3: 
					System.out.println("Enter Id to be updated");
					BigInteger eid = sc.nextBigInteger();
					System.out.println("Enter the name");
					sc.nextLine();
					String ename = sc.nextLine();
					System.out.println("Enter the salary");
					BigDecimal esal = sc.nextBigDecimal();
					Employee eemp = new Employee(eid,ename,esal);
					try {
						service.updateEmployee(eemp);
						System.out.println("updated");
					} catch (EmployeeException e) {
						System.err.println(e.getMessage());
					}
					break;
				case 4:
					List<Employee> empList = service.findAll();
					for(Employee employee : empList) {
						System.out.println(employee);
					}
					break;
				case 5:
					System.out.println("Enter emp id");
					BigInteger empId = sc.nextBigInteger();
					System.out.println(service.findEmployee(empId));
					break;
				case 6:
					System.out.println("Enter min and max");
					BigDecimal min = sc.nextBigDecimal();
					BigDecimal max = sc.nextBigDecimal();
					List<Employee> empList1 = service.findSalaryList(min, max);
					for(Employee employee : empList1) {
						System.out.println(employee);
					}
					break;
				case 0:
					x = 0;
					break;
				
				default:
					System.out.println("Enter Valid Input!");
				
			}
			System.out.println("Choose what you wanna do");
			System.out.println("1. Enter an Employee");
			System.out.println("2. Delete an Employee");
			System.out.println("3. Update an Employee");
			System.out.println("4. Show all emp");
			System.out.println("5. Find an Employee");
			System.out.println("6. Show employees within specific salary range");
			System.out.println("0. Exit");
			x = sc.nextInt();		
		}
		sc.close();		
	}

}

	