package com.skypro.employeebookmockito.services.impl;

import com.skypro.employeebookmockito.exceptions.EmployeeNotFoundException;
import com.skypro.employeebookmockito.models.Employee;
import com.skypro.employeebookmockito.services.DepartmentService;
import com.skypro.employeebookmockito.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Map<Integer, List<Employee>> employees() {
        return employeeService.allEmployee().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public int sum(int id) {
        return employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == id)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public int min(int id) {
        return employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == id)
                .mapToInt(Employee::getSalary)
                .min()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public int max(int id) {
        return employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == id)
                .mapToInt(Employee::getSalary)
                .max()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> employeesAll(int id) {
        return employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == id)
                .collect(Collectors.toList());
    }
}
