package com.example.fawryApp.service;

import com.example.fawryApp.entity.Employee;
import com.example.fawryApp.repository.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    private EmployeeRepo employeeRepo;
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeRepo = Mockito.mock(EmployeeRepo.class); // mock repo
        employeeService = new EmployeeService(employeeRepo);
    }

    @Test
    void testAddEmployee() {
        Employee employee = new Employee(1, "Ibrahim", 23, "ibrahim@example.com");

        when(employeeRepo.addEmployee(employee)).thenReturn(employee);

        Employee result = employeeService.addEmployee(employee);

        assertNotNull(result);
        assertEquals("Ibrahim", result.getName());
        verify(employeeRepo, times(1)).addEmployee(employee);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ibrahim", 23, "ibrahim@example.com"),
                new Employee(2, "Sara", 29, "sara@example.com")
        );

        when(employeeRepo.getAllEmployees()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployees();

        assertEquals(2, result.size());
        verify(employeeRepo, times(1)).getAllEmployees();
    }

    @Test
    void testGetEmployeeById() {
        Employee employee = new Employee(1, "Ibrahim", 23, "ibrahim@example.com");

        when(employeeRepo.getEmployee(1)).thenReturn(employee);

        Employee result = employeeService.getEmployee(1);

        assertEquals("Ibrahim", result.getName());
        assertEquals(23, result.getAge());
        verify(employeeRepo, times(1)).getEmployee(1);
    }

    @Test
    void testRemoveEmployee() {
        Employee employee = new Employee(1, "Ibrahim", 23, "ibrahim@example.com");

        when(employeeRepo.getEmployee(1)).thenReturn(employee);

        Employee result = employeeService.RemoveEmployee(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(employeeRepo, times(1)).getEmployee(1);
        verify(employeeRepo, times(1)).removeEmployee(1);
    }

    @Test
    void testUpdateEmployee() {
        Employee updatedEmployee = new Employee(1, "Ibrahim", 24, "ibrahim@example.com");

        when(employeeRepo.updateEmployee(updatedEmployee)).thenReturn(updatedEmployee);

        Employee result = employeeService.UpdateEmployee(updatedEmployee);

        assertEquals(24, result.getAge());
        verify(employeeRepo, times(1)).updateEmployee(updatedEmployee);
    }
}
