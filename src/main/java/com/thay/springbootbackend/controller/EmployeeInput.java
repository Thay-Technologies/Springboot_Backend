
package com.thay.springbootbackend.controller;

import com.thay.springbootbackend.entity.EmployeeEntity;
import lombok.Data;

@Data
public class EmployeeInput {
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


    public EmployeeEntity toEmployeeEntity() {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setEmployeeId(this.employeeId);
        employee.setEmployeeName(this.employeeName);
        employee.setEmployeeAge(this.employeeAge);
        employee.setEmployeeGender(this.employeeGender);
        employee.setEmployeeDOJ(this.employeeDOJ);
        employee.setEmployeeRemarks(this.employeeRemarks);
        employee.setEmployeeAccruedLeaves(this.employeeAccruedLeaves);
        employee.setEmail(this.email);
        employee.setPassword(this.password);
        employee.setRoleName(this.roleName);
        return employee;
    }
}