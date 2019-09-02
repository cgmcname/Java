package edu.uark.models.api;

import java.util.LinkedList;
import java.util.List;

public class EmployeeListing {
	private List<Employee> Employees;
	public List<Employee> getEmployees() {
		return this.Employees;
	}
	public EmployeeListing setEmployees(List<Employee> Employees) {
		this.Employees = Employees;
		return this;
	}
	public EmployeeListing addEmployee(Employee Employee) {
		this.Employees.add(Employee);
		return this;
	}
	
	public EmployeeListing() {
		this.Employees = new LinkedList<Employee>();
	}
}
