package com.example.fawryApp.configuration;

import com.example.fawryApp.entity.Employee;
import com.example.fawryApp.repository.EmployeeRepo;
import com.example.fawryApp.service.EmployeeService;
import jdk.jfr.Name;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
    @Bean(name = "employeeRepo")
    public EmployeeRepo employeeRepo() {
        return new EmployeeRepo();
    }

    @Bean(name = "employeeService")
    public EmployeeService employeeService(EmployeeRepo employeeRepo) {
        return new EmployeeService(employeeRepo);
    }

}
