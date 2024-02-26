package com.thay.springbootbackend.service;

import com.thay.springbootbackend.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> getAllEmployees();
    EmployeeEntity getEmployeeById(int employeeId);
    EmployeeEntity createEmployee(EmployeeEntity employee);
    EmployeeEntity updateEmployee(int employeeId, EmployeeEntity employee);
    EmployeeEntity deleteEmployee(int employeeId);
}
