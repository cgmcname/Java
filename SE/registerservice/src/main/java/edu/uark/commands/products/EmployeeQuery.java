package edu.uark.commands.products;

import java.util.UUID;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Employee;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeQuery implements ResultCommandInterface<Employee> {
	
	@Override
	public Employee execute() {
		return new Employee(
//			this.employeeRepository.get(this.recordID)
		);
	}

	//Properties
	private String recordID;
	public String getRecordID() {
		return this.recordID;
	}
	public EmployeeQuery setRecordID(String recordID) {
		this.recordID = recordID;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeQuery setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeQuery() {
	//	this.employeeRepository = new EmployeeRepository();
		////
	}
}
