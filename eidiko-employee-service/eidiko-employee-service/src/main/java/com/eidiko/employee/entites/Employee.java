package com.eidiko.employee.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @Column(name = "EMP_ID")
    private long empId;
    @Column(name = "EMP_NAME")
    private String empName;
    @Column(name = "EMAIL_ID")
    private String emailId;
    @Column(name = "DATE_OF_JOINING")
    private Timestamp dateOfJoining;
    @Column(name = "MODIFIED_DATE")
    private Timestamp modifiedDate;
    @Column(name = "CONTACT_NO")
    private String ContactNo;
    @Column(name = "CREATED_BY")
    private long createdBy;
    @Column(name = "IS_DELETED")
    private  boolean isDeleted;
    @Column(name = "STATUS")
    private String status;
    @OneToOne(mappedBy = "employee")
    @JsonBackReference
    private ReportingManager reportingManager;

}
