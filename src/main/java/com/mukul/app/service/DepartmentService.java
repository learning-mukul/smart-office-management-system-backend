package com.mukul.app.service;

import com.mukul.app.entity.Department;
import com.mukul.app.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
         this.departmentRepository=departmentRepository;
    }

    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
}
