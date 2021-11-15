package com.example.ss.boot.dao;

import com.example.ss.boot.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> findAll();
}
