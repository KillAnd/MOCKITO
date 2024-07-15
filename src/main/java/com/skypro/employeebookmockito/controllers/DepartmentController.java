package com.skypro.employeebookmockito.controllers;

import com.skypro.employeebookmockito.models.Employee;
import com.skypro.employeebookmockito.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> employees () {
        return departmentService.employees();
    }

    @GetMapping("/{id}/salary/sum")
    public int sum(@PathVariable int id) {
        return departmentService.sum(id);
    }

    @GetMapping("/{id}/salary/max")
    public  int max(@PathVariable int id) {
        return departmentService.max(id);
    }

    @GetMapping("/{id}/salary/min")
    public  int min(@PathVariable int id) {
        return departmentService.min(id);
    }

    @GetMapping("{id}/employees")
    public List<Employee> employeesAll(@PathVariable int id) {
        return departmentService.employeesAll(id);
    }
}
