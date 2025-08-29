package com.example.fawryApp.repository;

import com.example.fawryApp.entity.Employee;
import com.example.fawryApp.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRepoTest {
    private EmployeeService service;

    @BeforeEach
    void setUp() {
        EmployeeRepo repo = new EmployeeRepo();
        repo.addEmployee(new Employee(1, "Ibrahim", 25, "ibrahim@test.com"));
        repo.addEmployee(new Employee(2, "Sara", 28, "sara@test.com"));
        service = new EmployeeService(repo);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = service.getAllEmployees();
        assertEquals(2, employees.size());
    }

    @Test
    void testGetEmployee_found() {
        Employee emp = service.getEmployee(1);
        assertNotNull(emp);
        assertEquals("Ibrahim", emp.getName());
    }

    @Test
    void testGetEmployee_notFound() {
        Employee emp = service.getEmployee(99);
        assertNull(emp);
    }

    @Test
    void testAddEmployee() {
        Employee newEmp = new Employee(3, "Omar", 30, "omar@test.com");
        service.addEmployee(newEmp);
        assertEquals(3, service.getAllEmployees().size());
    }
}

