package com.kalpit00.Springboot.tutorial.controller;

import com.kalpit00.Springboot.tutorial.entity.Department;
import com.kalpit00.Springboot.tutorial.error.DepartmentNotFoundException;
import com.kalpit00.Springboot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController  {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    public boolean existsById(Long departmentId) {
        return departmentService.existsById(departmentId);
    }

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        boolean exists = existsById(departmentId);
        if (exists) {
            departmentService.deleteDepartmentById(departmentId);
        }
        return exists ? "Department Deleted Successfully!" : "Department with id = [" + departmentId + "] does not exist!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        boolean exists = existsById(departmentId);
        if (exists) {
            return departmentService.updateDepartmentById(departmentId, department);
        }
        return saveDepartment(department);
    }

}
