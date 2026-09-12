package com.mukul.app.service;

import com.mukul.app.entity.Employee;
import com.mukul.app.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeEventProducer eventProducer;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeEventProducer eventProducer){
        this.employeeRepository=employeeRepository;
        this.eventProducer = eventProducer;
    }

    public Employee saveEmployee(Employee employee){
        Employee e= employeeRepository.save(employee);
        eventProducer.sendWelcomeEvent(employee.getName(), employee.getEmail());
        return e;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesByDepartmentId(Long departmentId){
        return employeeRepository.findByDepartmentId(departmentId);
    }
}
