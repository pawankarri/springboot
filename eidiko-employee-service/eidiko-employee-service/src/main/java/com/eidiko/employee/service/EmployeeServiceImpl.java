package com.eidiko.employee.service;

import com.eidiko.employee.dto.EmployeeDto;
import com.eidiko.employee.entites.Employee;
import com.eidiko.employee.entites.ReportingManager;
import com.eidiko.employee.repository.EmployeeRepository;
import com.eidiko.employee.repository.ReportingManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ReportingManagerRepository reportingManagerRepository;
    public List<Employee> getAllEmployees() {
        List<Employee> list=employeeRepository.findAll();
        return list;
    }


    @Override
    public Optional<Employee> getEmployeeById(long empId)
    {
        return employeeRepository.findById(empId);

    }




    @Override
    public ReportingManager addingEmployee(EmployeeDto employeeDto){
        Employee employee=new Employee();
        employee.setEmpId(employeeDto.getEmpId());
        employee.setEmpName(employeeDto.getEmpName());
        employee.setEmailId(employeeDto.getEmailId());
        employee.setStatus(employeeDto.getStatus());
        employee.setDateOfJoining(employeeDto.getDateOfJoining());
        employee=employeeRepository.save(employee);

        ReportingManager reportingManager=new ReportingManager(employeeDto);
        reportingManager.setEmployee(employee);
        reportingManager=reportingManagerRepository.save(reportingManager);
        return reportingManager;

    }
    public Employee updateEmployee(EmployeeDto employeeDto,long empId)
    {
      Optional<Employee>list=  employeeRepository.findById(empId);
        if(list.isPresent()){
            Employee employee=list.get();
            employee.setEmpName(employeeDto.getEmpName());
            employee.setStatus(employeeDto.getStatus());
            employee.setDateOfJoining(employeeDto.getDateOfJoining());
            employee=employeeRepository.save(employee);
           return employee;
        }
        return null;
    }
}
