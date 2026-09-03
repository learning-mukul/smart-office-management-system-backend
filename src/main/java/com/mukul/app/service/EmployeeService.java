package com.mukul.app.service;

import com.mukul.app.entity.Employee;
import com.mukul.app.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesByDepartmentId(Long departmentId){
        return employeeRepository.findByDepartmentId(departmentId);
    }
}
