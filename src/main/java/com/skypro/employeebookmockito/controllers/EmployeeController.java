package com.skypro.employeebookmockito.controllers;

import com.skypro.employeebookmockito.models.Employee;
import com.skypro.employeebookmockito.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String fullName,
                                @RequestParam int salary, @RequestParam int department) {
        return employeeService.addEmployee(fullName,salary,department);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String fullName) {
        return employeeService.findEmployee(fullName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String fullName) {
        return employeeService.removeEmployee(fullName);
    }

    @GetMapping("/all")
    public List<Employee> allEmployee() {
        return employeeService.allEmployee();
    }
}
