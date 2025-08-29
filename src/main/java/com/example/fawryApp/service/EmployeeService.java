package com.example.fawryApp.service;

import com.example.fawryApp.entity.Employee;
import com.example.fawryApp.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employeeRepo.addEmployee(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.getAllEmployees();
    }
    public Employee getEmployee(int id) {
        return employeeRepo.getEmployee(id);
    }

    public Employee RemoveEmployee(int id) {
        Employee e  = employeeRepo.getEmployee(id);
        employeeRepo.removeEmployee(id);
        return e;
    }

    public Employee UpdateEmployee(Employee employee) {
        employeeRepo.updateEmployee(employee);
        return employee;
    }
}
