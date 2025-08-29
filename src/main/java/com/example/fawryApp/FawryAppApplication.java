package com.example.fawryApp;

import com.example.fawryApp.configuration.Config;
import com.example.fawryApp.entity.Employee;
import com.example.fawryApp.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FawryAppApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Config.class);
//        //
////        ClassPathXmlApplicationContext app =
////                new ClassPathXmlApplicationContext("AppContext.xml");
//        Employee emp = app.getBean(Employee.class);
//        Employee emp1 = app.getBean(Employee.class);
////        Department department = app.getBean(Department.class);
//        System.out.println(emp.getName());
////        System.out.println(department.getName())
//
//
//        System.out.println(emp.toString());
//        System.out.println(emp1.toString());
        EmployeeService service = app.getBean(EmployeeService.class);

        //Create
        System.out.println("\t\t\t\tGet all Employees\n--------------------------------------------------");
        service.addEmployee(new Employee(1, "Ibrahim", 23, "ibrahim@email.com"));
        service.addEmployee(new Employee(2, "Ali", 25, "ali@email.com"));
        service.addEmployee(new Employee(3, "Omar", 35, "omar@example.com"));
        service.addEmployee(new Employee(4, "Mona", 27, "mona@example.com"));
        service.addEmployee(new Employee(5, "Ali", 31, "ali@example.com"));
        service.addEmployee(new Employee(6, "Nour", 22, "nour@example.com"));
        service.addEmployee(new Employee(7, "Hassan", 40, "hassan@example.com"));
        service.addEmployee(new Employee(8, "Layla", 26, "layla@example.com"));
        service.addEmployee(new Employee(9, "Khaled", 33, "khaled@example.com"));
        service.addEmployee(new Employee(10, "Fatma", 28, "fatma@example.com"));
        //Get all Employees
        service.getAllEmployees().forEach(e ->
                System.out.println(e.getId() + " - " + e.getName() + " - " + e.getEmail())
        );
        System.out.println("\n");

        //Get a specific Employee using ID
        System.out.println("\t\tGet a specific Employee name using ID\n--------------------------------------------------");
        Employee fetchedEmployee = service.getEmployee(1);
        System.out.println("Fetched employee: " + fetchedEmployee.getName());
        System.out.println("\n");

        //Delete a specific Employee using ID
        System.out.println("\t\t\tDelete an Employee\n--------------------------------------------------");
        Employee deletedEmployee = service.RemoveEmployee(2);
        System.out.println("Deleted employee: " + deletedEmployee.getName());
        System.out.println("\n");

        //Update a specific Employee using ID
        System.out.println("\t\t\tUpdate an Employee\n--------------------------------------------------");
        Employee updatedEmployee = service.UpdateEmployee(new Employee(8, "Layla", 26, "layla@example.com"));
        System.out.println("Updated employee: " + updatedEmployee.getName());
        System.out.println("\n");
    }
}
