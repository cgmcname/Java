package edu.uark.commands.products;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Employee;
import edu.uark.models.api.enums.EmployeeApiRequestStatus;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeSaveCommand implements ResultCommandInterface<Employee> {


	@Override
	public Employee execute() {
		if (StringUtils.isBlank(this.apiEmployee.getrecordId())) {
			return (new Employee()).setApiRequestStatus(EmployeeApiRequestStatus.INVALID_INPUT);
		}
		
		EmployeeEntity Employeeentity = this.EmployeeRepository.get(this.apiEmployee.getrecordId());
		if (Employeeentity != null) {
			this.apiEmployee = Employeeentity.synchronize(this.apiEmployee);
		} else {
			Employeeentity = this.EmployeeRepository.byRecordID(this.apiEmployee.getrecordId());
			if (Employeeentity == null) {
				Employeeentity = new EmployeeEntity(this.apiEmployee);
			} else {
				return (new Employee()).setApiRequestStatus(EmployeeApiRequestStatus.LOOKUP_CODE_ALREADY_EXISTS);
			}
		}
		
		Employeeentity.save();
		if (this.apiEmployee.getrecordId() == "") {
			this.apiEmployee.setId(Employeeentity.getRecordID());
		}
		
		return this.apiEmployee;
	}

	//Properties
	private Employee apiEmployee;
	public Employee getApiEmployee() {
		return this.apiEmployee;
	}
	public EmployeeSaveCommand setApiEmployee(Employee apiEmployee) {
		this.apiEmployee = apiEmployee;
		return this;
	}
	
	private EmployeeRepositoryInterface EmployeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.EmployeeRepository;
	}
	public EmployeeSaveCommand setEmployeeRepository(EmployeeRepositoryInterface EmployeeRepository) {
		this.EmployeeRepository = EmployeeRepository;
		return this;
	}
	
	public EmployeeSaveCommand() {
		this.EmployeeRepository = new EmployeeRepository(); 
	} 
}

