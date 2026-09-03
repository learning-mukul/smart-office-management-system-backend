package com.mukul.app.controller;


import com.mukul.app.entity.Department;
import com.mukul.app.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class Departmentcontroller {
    private final DepartmentService departmentService;

    public Departmentcontroller(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartments();
    }
}
