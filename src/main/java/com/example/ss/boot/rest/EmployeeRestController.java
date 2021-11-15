package com.example.ss.boot.rest;

import com.example.ss.boot.dao.EmployeeDao;
import com.example.ss.boot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeRestController (EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployee() {
        return employeeDao.findAll();
    }
}
