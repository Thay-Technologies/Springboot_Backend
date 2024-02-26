package com.thay.springbootbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    private int employeeId;
    private String employeeName;
    private int employeeAge;
    private String employeeGender;
    private String employeeDOJ;
    private String employeeRemarks;
    private Integer employeeAccruedLeaves;
    private String email;
    private String password;
    private String roleName;
}
