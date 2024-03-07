package com.thay.springbootbackend.controller;

import com.thay.springbootbackend.controller.input.EmployeeInput;
import com.thay.springbootbackend.entity.EmployeeEntity;
import com.thay.springbootbackend.service.EmployeeService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @QueryMapping("getAllEmployees")
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @MutationMapping("createEmployee")
    public EmployeeEntity createEmployee(@Argument("input") EmployeeInput employeeInput) {
        return employeeService.createEmployee(employeeInput.toEmployeeEntity());
    }



    @MutationMapping("updateEmployee")
    public EmployeeEntity updateEmployee(@Argument("employeeId") int employeeId, @Argument("input") EmployeeInput employeeInput) {
        return employeeService.updateEmployee(employeeId, employeeInput.toEmployeeEntity());
    }

    @MutationMapping("deleteEmployee")
    public EmployeeEntity deleteEmployee(@Argument("employeeId") int employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }



    @QueryMapping("getEmployeeById")
    public EmployeeEntity getEmployeeById(@Argument("employeeId") int employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }
}
