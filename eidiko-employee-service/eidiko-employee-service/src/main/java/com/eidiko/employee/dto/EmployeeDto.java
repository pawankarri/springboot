package com.eidiko.employee.dto;

import jakarta.validation.constraints.*;
import lombok.Data;


import java.sql.Time;
import java.sql.Timestamp;
@Data

public class EmployeeDto {
    private long empId;
    @NotBlank(message="name must  be notnull")
    private String empName;
    @Email
    @NotBlank
    private String emailId;
    private long managerId;
    private Timestamp dateOfJoining;
    @NotBlank(message="status must be notnull")
    private String status;
    @NotNull(message="shiftstarttime must be notnull")
    private Time shiftStartTime;

    private Time shiftEndTIme;
}
