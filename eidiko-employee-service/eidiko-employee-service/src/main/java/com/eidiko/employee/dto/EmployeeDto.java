package com.eidiko.employee.dto;

import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
@Data

public class EmployeeDto {
    private long empId;
    private String empName;
    private String emailId;
    private long managerId;
    private Timestamp dateOfJoining;
    private String status;
    private Time shiftStartTime;
    private Time shiftEndTIme;
}
