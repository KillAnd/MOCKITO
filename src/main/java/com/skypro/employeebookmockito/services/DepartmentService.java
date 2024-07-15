package com.skypro.employeebookmockito.services;

import com.skypro.employeebookmockito.models.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Map<Integer, List<Employee>> employees();

    int sum(int id);

    int min(int id);

    int max(int id);

    List<Employee> employeesAll(int id);
}


