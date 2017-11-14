package com.sda.planer.planer.controller;

import com.sda.planer.planer.model.Employee;
import com.sda.planer.planer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class ApiEmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public ApiEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("{id}")
    public Employee getOne(@PathVariable("id") long id) {
        return employeeService.get(id);
    }
}
