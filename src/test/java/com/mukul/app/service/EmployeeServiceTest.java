package com.mukul.app.service;

import com.mukul.app.entity.Employee;
import com.mukul.app.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

private final EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);
private final EmployeeEventProducer eventProducer = Mockito.mock(EmployeeEventProducer.class);
private final EmployeeService employeeService = new EmployeeService(employeeRepository, eventProducer);

@Test
void testGetAllEmployees() {
    Employee e1 = new Employee();
    e1.setName("Mukul");
    Employee e2 = new Employee();
    e2.setName("Raj");

    when(employeeRepository.findAll()).thenReturn(Arrays.asList(e1, e2));

    List<Employee> employees = employeeService.getEmployees();

    assertEquals(2, employees.size());
    verify(employeeRepository, times(1)).findAll();
}
}