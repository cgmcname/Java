package edu.uark.controllers;

import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.products.EmployeebyRecordID;
import edu.uark.commands.products.EmployeeQuery;
import edu.uark.commands.products.EmployeeSaveCommand;
import edu.uark.commands.products.EmployeesQuery;
import edu.uark.models.api.Employee;
import edu.uark.models.api.EmployeeListing;


@RestController
@RequestMapping(value = "/employee")
public class EmployeeRestController { 
	


	@RequestMapping(value = "/apiv0/isActive", method = RequestMethod.GET)
	public Employee getEmployeeCounts1(@PathVariable String recordID) {
		return (new EmployeeQuery()).
			setRecordID(recordID).
			execute();
	} 
	// TO DO
	/* @RequestMapping(value = "/apiv0/byRecordID/{productLookupCode}", method = RequestMethod.GET)
	public Product getProductByLookupCode(@PathVariable String productLookupCode) {
		return (new ProductByLookupCodeQuery()).
			setLookupCode(productLookupCode).
			execute();
	} */
	
	
	//TO DO
	 @RequestMapping(value = "/apiv0/employees", method = RequestMethod.GET)
	public EmployeeListing getEmployees() {
		return (new EmployeesQuery()).execute();
	} 
	
	@RequestMapping(value = "/apiv0/", method = RequestMethod.PUT)
	public Employee putActivity(@RequestBody Employee employee) {
			return (new EmployeeSaveCommand()).
			setApiEmployee(employee).
			execute();
		}

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (EmployeeRestController)";
	}



    @RequestMapping(value = "/apiv0/isActive", method = RequestMethod.GET)
    public Employee getEmployeeCounts(@PathVariable String recordID) {
        return (new EmployeeQuery()).
            setRecordID(recordID).
            execute();
    }
    


} 


