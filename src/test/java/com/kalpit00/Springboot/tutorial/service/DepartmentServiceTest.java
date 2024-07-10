package com.kalpit00.Springboot.tutorial.service;

import com.kalpit00.Springboot.tutorial.entity.Department;
import com.kalpit00.Springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentId(1L).departmentName("IT").departmentAddress("Delhi").
                departmentCode("IT-06").build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Test_Service_fetchDepartmentByName1")
    public void validDepartmentName() {
        String test_departmentName = "IT";
        Department department = departmentService.fetchDepartmentByName(test_departmentName);
        assertEquals(test_departmentName, department.getDepartmentName());
    }
}