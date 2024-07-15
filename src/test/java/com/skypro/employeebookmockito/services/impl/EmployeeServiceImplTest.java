package com.skypro.employeebookmockito.services.impl;

import com.skypro.employeebookmockito.exceptions.EmployeeAlreadyAddedException;
import com.skypro.employeebookmockito.exceptions.EmployeeNotFoundException;
import com.skypro.employeebookmockito.models.Employee;
import com.skypro.employeebookmockito.services.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class EmployeeServiceImplTest {

    private final EmployeeService employeeService = new EmployeeServiceImpl();


    @Test
    public void shouldCorrectlyAddEmployees() {
        Employee expectedEmployee = new Employee("Анатолий Борисович", 250_000, 3);
        Employee actualEmployee = employeeService.addEmployee(expectedEmployee.getFullName(),
                expectedEmployee.getSalary(), expectedEmployee.getDepartment());
        Assertions.assertEquals(expectedEmployee,actualEmployee);
    }

    @Test
    public void checkingForTheExceptionOfAddingAnEmployee() {
        employeeService.addEmployee("Анатолий Борисович", 250_000, 3);
        Assertions.assertThrowsExactly(EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee("Анатолий Борисович", 250_000, 3));
    }

    @Test
    public void checkingCorrectlyRemoveEmployee() {
        Employee expectedEmployee = employeeService.addEmployee("Анатолий Борисович", 250_000, 3);
        employeeService.removeEmployee(expectedEmployee.getFullName());
        Assertions.assertFalse(employeeService.allEmployee().contains(expectedEmployee));
    }

    @Test
    public void checkingIfThereIsAnEmployeeForRemove() {
        Assertions.assertThrowsExactly(EmployeeNotFoundException.class,
                () -> employeeService.removeEmployee("Анатолий Борисович"));

    }

    @Test
    public void checkingCorrectlyFindEmployee() {
        Employee addEmployee = employeeService.addEmployee("Антон Сидоров", 28000, 1);
        Employee findEmployee = employeeService.findEmployee("Антон Сидоров");
        Assertions.assertEquals(findEmployee,addEmployee);
    }

    @Test
    public void checkingIfThereIsAnEmployeeForFind() {
        Assertions.assertThrowsExactly(EmployeeNotFoundException.class,
                () -> employeeService.findEmployee("Анатолий Борисович"));

    }


}
