package com.thay.springbootbackend.service;

import com.thay.springbootbackend.entity.EmployeeEntity;
import com.thay.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity getEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("EmployeeId not found"));
    }

    @Override
    public EmployeeEntity createEmployee(EmployeeEntity employee) {

        return employeeRepository.save(employee);
    }



    @Override
    public EmployeeEntity updateEmployee(int employeeId, EmployeeEntity employee) {
        EmployeeEntity existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("EmployeeId not found"));


        existingEmployee.setEmployeeName(employee.getEmployeeName());
        existingEmployee.setEmployeeAge(employee.getEmployeeAge());
        existingEmployee.setEmployeeGender(employee.getEmployeeGender());
        existingEmployee.setEmployeeDOJ(employee.getEmployeeDOJ());
        existingEmployee.setEmployeeRemarks(employee.getEmployeeRemarks());
        existingEmployee.setEmployeeAccruedLeaves(employee.getEmployeeAccruedLeaves());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPassword(employee.getPassword());
        existingEmployee.setRoleName(employee.getRoleName());


        return employeeRepository.save(existingEmployee);
    }

    @Override
    public EmployeeEntity deleteEmployee(int employeeId) {

        EmployeeEntity deletedEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("EmployeeId not found"));


        employeeRepository.deleteById(employeeId);


        return deletedEmployee;
    }
}