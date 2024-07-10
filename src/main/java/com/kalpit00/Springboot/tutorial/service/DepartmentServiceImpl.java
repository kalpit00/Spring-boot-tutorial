package com.kalpit00.Springboot.tutorial.service;

import com.kalpit00.Springboot.tutorial.entity.Department;
import com.kalpit00.Springboot.tutorial.error.DepartmentNotFoundException;
import com.kalpit00.Springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =  departmentRepository.findById(departmentId);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not found!");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public boolean existsById(Long departmentId) {
        return departmentRepository.existsById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department oldDepartment = departmentRepository.findById(departmentId).get();
        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            oldDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {
            oldDepartment.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            oldDepartment.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(oldDepartment);
    }
}
