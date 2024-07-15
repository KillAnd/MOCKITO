package com.skypro.employeebookmockito.services.impl;

import com.skypro.employeebookmockito.models.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private final List<Employee> employeesTest = new ArrayList<>(List.of(
            new Employee("Иван Аркадьевич", 200_000, 1),
            new Employee("Иван Андреевич", 190_000, 1),
            new Employee("Иван Анатольевич", 180_000, 1),
            new Employee("Руслан Аркадьевич", 170_000, 2),
            new Employee("Руслан Андреевич", 160_000, 2),
            new Employee("Руслан Анатольевич", 150_000, 2),
            new Employee("Аркадий Аркадьевич", 140_000, 3),
            new Employee("Аркадий Андреевич", 130_000, 3),
            new Employee("Аркадий Анатольевич", 120_000, 3),
            new Employee("Владимир Аркадьевич", 110_000, 4),
            new Employee("Владимир Андреевич", 105_000, 4),
            new Employee("Владимир Анатольевич", 100_000, 4)
    ));


    @Test
    public void checkingCorrectlyOutputEmployeeForDepartment() {
        int department = 1;

        Mockito.when(employeeService.allEmployee()).thenReturn(employeesTest);

        List<Employee> expectedEmployees = List.of(employeesTest.get(0),employeesTest.get(1),employeesTest.get(2));

        List<Employee> actualEmployees = departmentService.employeesAll(department);

        Assertions.assertEquals(actualEmployees,expectedEmployees);
    }

    @Test
    public void checkingCorrectlySumSalaryForEmployee() {
        int department = 1;

        Mockito.when(employeeService.allEmployee()).thenReturn(employeesTest);

        Integer expectedEmployees = employeesTest.get(0).getSalary() +
                employeesTest.get(1).getSalary() + employeesTest.get(2).getSalary();

        int actualEmployees = departmentService.sum(department);

        Assertions.assertEquals(actualEmployees,expectedEmployees);
    }

    @Test
    public void checkingCorrectlyMinSalaryForEmployee() {
        int department = 1;

        Mockito.when(employeeService.allEmployee()).thenReturn(employeesTest);

        Integer expectedEmployees = employeesTest.get(2).getSalary();

        int actualEmployees = departmentService.min(department);

        Assertions.assertEquals(actualEmployees,expectedEmployees);
    }

    @Test
    public void checkingCorrectlyMaxSalaryForEmployee() {
        int department = 1;

        Mockito.when(employeeService.allEmployee()).thenReturn(employeesTest);

        Integer expectedEmployees = employeesTest.get(0).getSalary();

        int actualEmployees = departmentService.max(department);

        Assertions.assertEquals(actualEmployees,expectedEmployees);
    }







}
