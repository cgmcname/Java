package edu.uark.commands.products;

import java.util.stream.Collectors;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Employee;
import edu.uark.models.api.EmployeeListing;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeesQuery implements ResultCommandInterface<EmployeeListing> {
	@Override
	public EmployeeListing execute() {
		return (new EmployeeListing()).
			setEmployees(
				this.employeeRepository.
					all().
					stream().
					map(mp -> (new Employee(mp))).
					collect(Collectors.toList()
			)
		);
	}

	//Properties
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getProductRepository() {
		return this.employeeRepository;
	}
	public EmployeesQuery setProductRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeesQuery() {
		this.employeeRepository = new EmployeeRepository();
	}
}
