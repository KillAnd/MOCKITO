package com.skypro.employeebookmockito.services;

import com.skypro.employeebookmockito.models.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(String fullName, int salary, int department);

    Employee findEmployee(String fullName);

    Employee removeEmployee(String fullName);

    List<Employee> allEmployee();

}
