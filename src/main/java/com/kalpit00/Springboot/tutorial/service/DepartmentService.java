package com.kalpit00.Springboot.tutorial.service;

import com.kalpit00.Springboot.tutorial.entity.Department;
import com.kalpit00.Springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public boolean existsById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
