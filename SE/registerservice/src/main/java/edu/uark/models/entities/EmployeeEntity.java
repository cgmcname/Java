package edu.uark.models.entities;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.api.Employee;
import edu.uark.models.api.Product;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.ProductRepository;

public class EmployeeEntity extends BaseEntity<EmployeeEntity>  {
	String recordID;
	String firstName;
	String lastName;
	int empID;
	int isActive;
	String emprole;
	String manager;
	String password;
	LocalDateTime timeOn;

	
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.recordID = rs.getString(EmployeeFieldNames.RECORDID);
		this.firstName = rs.getString(EmployeeFieldNames.FIRSTNAME);
		this.lastName = rs.getString(EmployeeFieldNames.LASTNAME);
		this.password = rs.getString(EmployeeFieldNames.PASSWORD);
		this.manager = rs.getString(EmployeeFieldNames.MANAGER);
		this.empID = rs.getInt(EmployeeFieldNames.EMPLOYEEID);
		this.emprole = rs.getString(EmployeeFieldNames.EMPLOYEEROLE);
		this.timeOn = rs.getTimestamp(EmployeeFieldNames.CREATED_ON).toLocalDateTime();
	}
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		 record.put(EmployeeFieldNames.RECORDID , this.recordID);
		 record.put(EmployeeFieldNames.FIRSTNAME , this.firstName);
		 record.put(EmployeeFieldNames.LASTNAME , this.lastName);
		 record.put(EmployeeFieldNames.PASSWORD , this.password);
		 record.put(EmployeeFieldNames.MANAGER , this.manager);
		 record.put(EmployeeFieldNames.EMPLOYEEID , this.empID);
		 record.put(EmployeeFieldNames.EMPLOYEEROLE , this.emprole);
		 record.put(EmployeeFieldNames.CREATED_ON , Timestamp.valueOf(this.timeOn)); 
		return record;
	}
	public String getRecordID()
	{
		return recordID; 
	}
	public String getfirstName()
	{
		return firstName; 
	}
	public String getlastName()
	{
		return lastName; 
	}
	public String getmanager()
	{
		return manager; 
	}	
	public int getempID()
	{
		return empID; 
	}
	public String getemprole()
	{
		return firstName; 
	}
	
	public int getisActive()
	{
		return isActive;
	}
	
	public String getpassword()
	{
		return password;
	}
	
	public LocalDateTime gettimeOn()
	{
		return timeOn;
	}
	
	public EmployeeEntity setCount(int count) {
		if (this.isActive != count) {
			this.isActive = count;
			this.propertyChanged(EmployeeFieldNames.ISACTIVE);
		}
		
		return this;
	}
	public EmployeeEntity setRecordID(String newRECID) {
		if (!StringUtils.equals(this.recordID, newRECID)) {
			this.recordID = newRECID;
			this.propertyChanged(EmployeeFieldNames.RECORDID);
		}
		
		return this;
	} 
	
	public EmployeeEntity() {
		super(new EmployeeRepository()); 
		this.isActive = -1;
		this.firstName = StringUtils.EMPTY;
		this.timeOn = LocalDateTime.now();
	} 
	public Employee synchronize(Employee apiEmployee) {
		this.setCount(apiEmployee.getisActive());
		this.setRecordID(apiEmployee.getrecordId());
		
		apiEmployee.settimeOn(this.timeOn);
		
		return apiEmployee;
	}
	public EmployeeEntity(Employee apiEmployee) {
		super(new EmployeeRepository());
		this.recordID = apiEmployee.getrecordId();
		this.firstName = apiEmployee.getfirstName();
		this.lastName = apiEmployee.getlastName();
		this.empID = apiEmployee.getempId();
		this.isActive = apiEmployee.getisActive();
		this.emprole = apiEmployee.getemprole();
		this.password = apiEmployee.getpassword();
		this.timeOn = LocalDateTime.now();

	}

}
