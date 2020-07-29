package com.joe.springbootRest.service;

import com.joe.springbootRest.dao.EmployeeRepository;
import com.joe.springbootRest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //No need to provide @Transactional on the methods because spring boot data jpa has that automatically
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result=employeeRepository.findById(id);
        Employee employee=null;
        if (result.isPresent())
            employee=result.get();
        else
            throw new RuntimeException("Not found"+ id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAList(Map<String,String> employeesQuery) {
        return employeeRepository.findByIdAndFirstName(Integer.parseInt(employeesQuery.get("id")),employeesQuery.get("name"));
    }

}
