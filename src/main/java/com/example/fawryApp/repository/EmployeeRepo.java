package com.example.fawryApp.repository;

import com.example.fawryApp.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepo {
    List<Employee> employees = new ArrayList<>();

    public EmployeeRepo() {}

    public Employee getEmployee(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }


    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public String removeEmployee(int id) {
        Employee e =  getEmployee(id);
        if (employees.contains(e)) {
        employees.remove(e);
        return "employee removed successfully";
        }
        return "employee not found";
    }

    public Employee updateEmployee(Employee employee) {
        for (Employee e : employees) {
            if (e.getId() == employee.getId()) {
                employee.setName(employee.getName());
                employee.setAge(employee.getAge());
                employee.setEmail(employee.getEmail());
                return employee;
            }
        };
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
