package com.eidiko.employee.entites;

import com.eidiko.employee.dto.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "REPORTING_MANAGER")
public class ReportingManager {
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REPORTING_MANAGER_ID")
    private long reportingManagerId;
    @Column(name = "MANAGER_ID")
    @Min(1)
    private long managerId;
    @Column(name = "MODIFIED_DATE")
    private Timestamp modifiedDate;
    @Column(name = "START_DATE")

    private Time startDate;
    @Column(name = "END_DATE")
    private Time endDate;
    @OneToOne
    @JoinColumn(name = "EMP_ID")
    @JsonManagedReference
    private Employee employee;

    public ReportingManager(EmployeeDto employeeDto){
        this.managerId=employeeDto.getManagerId();
        this.startDate=employeeDto.getShiftStartTime();
        this.endDate=employeeDto.getShiftEndTIme();
    }
}
