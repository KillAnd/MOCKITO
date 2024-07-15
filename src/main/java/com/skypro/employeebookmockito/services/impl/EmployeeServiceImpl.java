package com.skypro.employeebookmockito.services.impl;

import com.skypro.employeebookmockito.exceptions.EmployeeAlreadyAddedException;
import com.skypro.employeebookmockito.exceptions.EmployeeNotFoundException;
import com.skypro.employeebookmockito.models.Employee;
import com.skypro.employeebookmockito.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    @Override
    public Employee addEmployee(String fullName, int salary, int department) {
        if (employees.containsKey(fullName)) {
            throw new EmployeeAlreadyAddedException();
        }
        Employee employee = new Employee(fullName, salary, department);
        employees.put(fullName, employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String fullName) {
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(fullName);
    }

    @Override
    public Employee removeEmployee(String fullName) {
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(fullName);
    }

    @Override
    public List<Employee> allEmployee() {
        return new ArrayList<>(employees.values());
    }
}
