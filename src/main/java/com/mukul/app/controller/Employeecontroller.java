package com.mukul.app.controller;

import com.mukul.app.entity.Employee;
import com.mukul.app.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class Employeecontroller {

    private final EmployeeService employeeService;

    public Employeecontroller(EmployeeService employeeService){
        this.employeeService= employeeService;
    }

    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();

    }

    @GetMapping("/department/{id}")
    public List<Employee> getEmployeesByDepartment(@PathVariable Long id){
        return employeeService.getEmployeesByDepartmentId(id);
    }

}
