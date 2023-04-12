package com.eidiko.employee.service;

import com.eidiko.employee.dto.EmployeeDto;
import com.eidiko.employee.entites.Employee;
import com.eidiko.employee.entites.ReportingManager;
import com.eidiko.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public Optional<Employee> getEmployeeById(long empId);

    ReportingManager addingEmployee(EmployeeDto employeeDto);

}
