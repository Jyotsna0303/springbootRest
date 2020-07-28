package com.joe.springboot.crudhibernate.dao;

import com.joe.springboot.crudhibernate.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);

   public List<Employee> findAList(Map<String,String> employeeQuery);


}
