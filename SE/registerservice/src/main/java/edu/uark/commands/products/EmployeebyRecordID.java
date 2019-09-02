package edu.uark.commands.products;
import org.apache.commons.lang3.StringUtils;
import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Employee;
import edu.uark.models.api.enums.EmployeeApiRequestStatus;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;
public class EmployeebyRecordID implements ResultCommandInterface<Employee> {
    @Override
    public Employee execute() {
        if (StringUtils.isBlank(this.recordID)) {
            return new Employee().setApiRequestStatus(EmployeeApiRequestStatus.INVALID_INPUT);
        }
        
        EmployeeEntity employeeEntity = this.EmployeeRepository.byRecordID(this.recordID);
        if (employeeEntity != null)
            return new Employee(employeeEntity);
        else
            return new Employee().setApiRequestStatus(EmployeeApiRequestStatus.NOT_FOUND);
    }
        //Properties
        
        private String recordID;
        public String getrecordID() {
            return this.recordID;
        }
        public EmployeebyRecordID setrecordID(String recordID) {
            this.recordID = recordID;
            return this;
        }
        
        private EmployeeRepositoryInterface EmployeeRepository;
        public EmployeeRepositoryInterface getEmployeeRepository() {
            return this.EmployeeRepository;
        }
        public EmployeebyRecordID setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
            this.EmployeeRepository = employeeRepository;
            return this;
        }
        
        public EmployeebyRecordID() {
            this.EmployeeRepository = new EmployeeRepository();
        }
}