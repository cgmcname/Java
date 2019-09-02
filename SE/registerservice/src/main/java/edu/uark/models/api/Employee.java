package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.models.api.enums.EmployeeApiRequestStatus;
import edu.uark.models.entities.EmployeeEntity;

public class Employee {
	
	private String recordId;
	public String getrecordId() {
		return this.recordId;
	}
	
	public Employee setId(String Rid) {
		this.recordId = Rid;
		return this;
	}
	
	private String firstName;
	public String getfirstName() {
		return this.firstName;
	}
	public Employee setfirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	private String lastName;
	public String getlastName() {
		return this.lastName;
	}
	public Employee setlastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	private int empId;
	public int getempId() {
		return this.empId;
	}
	public Employee setempId(int empId) {
		this.empId = empId;
		return this;
	}
	
	private int isActive;
	public int getisActive() {
		return this.isActive;
	}
	public Employee setisActive(int isActive) {
		this.isActive = isActive;
		return this;
	}
	
	private String emprole;
	public String getemprole() {
		return this.emprole;
	}
	public Employee setemprole(int emprole) {
		this.isActive = emprole;
		return this;
	}
	
	private String manager;
	public String getmanager() {
		return this.manager;
	}
	public Employee setmanager(String manager) {
		this.manager = manager;
		return this;
	}
	
	private String password;
	public String getpassword() {
		return this.password;
	}
	public Employee setpassword(String password) {
		this.password = password;
		return this;
	}
	private LocalDateTime timeOn;
	public LocalDateTime gettimeOn() {
		return this.timeOn;
	}
	public Employee settimeOn(LocalDateTime timeOn) {
		this.timeOn = timeOn;
		return this;
	}
	

	private EmployeeApiRequestStatus apiRequestStatus;
	public EmployeeApiRequestStatus getApiRequestStatus() {
		return this.apiRequestStatus;
	}
	public Employee setApiRequestStatus(EmployeeApiRequestStatus apiRequestStatus) {
		if (this.apiRequestStatus != apiRequestStatus) {
			this.apiRequestStatus = apiRequestStatus;
		}
		
		return this;
	}
	
	private String apiRequestMessage;
	public String getApiRequestMessage() {
		return this.apiRequestMessage;
	}
	public Employee setApiRequestMessage(String apiRequestMessage) {
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) {
			this.apiRequestMessage = apiRequestMessage;
		}
		
		return this;
	}
	
	public Employee() {
		this.recordId = "";
		this.firstName = "";
		this.lastName = "";
		this.empId = 1;
		this.isActive = 1;
		this.emprole = "";
		this.manager = "";
		this.password = "";
		this.timeOn = LocalDateTime.now();
		
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = EmployeeApiRequestStatus.OK; 
	}
	
	public Employee(EmployeeEntity employeeEntity) {
		
		this.recordId = employeeEntity.getRecordID();
		this.firstName = employeeEntity.getfirstName();
		this.lastName = employeeEntity.getlastName();
		this.empId = employeeEntity.getempID();
		this.isActive = employeeEntity.getisActive();
		this.emprole = employeeEntity.getemprole();
		this.manager = employeeEntity.getmanager();
		this.password = employeeEntity.getpassword();
		this.timeOn = employeeEntity.gettimeOn();
		
		
		
		

		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = EmployeeApiRequestStatus.OK;
	}
}