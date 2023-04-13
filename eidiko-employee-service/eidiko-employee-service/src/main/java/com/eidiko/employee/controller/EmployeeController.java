package com.eidiko.employee.controller;

import com.eidiko.employee.dto.EmployeeDto;
import com.eidiko.employee.entites.Employee;
import com.eidiko.employee.entites.ReportingManager;
import com.eidiko.employee.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    @GetMapping("/employees")
    public List<Employee> getAllEmployees()
    {
        List<Employee> list=employeeServiceImpl.getAllEmployees();
        return list;
    }

    @GetMapping("/employees/{empId}")
    public Optional<Employee> getEmployeeById(@PathVariable("empId") long empId)
    {
       return  employeeServiceImpl.getEmployeeById(empId);
    }
    @PostMapping("/employee")
    public ReportingManager add(@Valid @RequestBody EmployeeDto employeeDto)
    {
      //  if(employeeDto.getManagerId()<0)
           // throw new MethodArgumentNotValidException();
       return employeeServiceImpl.addingEmployee(employeeDto);
    }

@PutMapping("/update/{id}")
    public Employee update(@PathVariable("id")long empId,@RequestBody EmployeeDto employeeDto){
    return    employeeServiceImpl.updateEmployee(employeeDto, empId);
    }
}
