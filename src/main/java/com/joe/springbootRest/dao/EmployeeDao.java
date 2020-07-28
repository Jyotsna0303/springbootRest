package com.joe.springbootRest.dao;

import com.joe.springbootRest.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);

    public List<Employee> findAList(Map<String,String> employeeQuery);
}
