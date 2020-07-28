package com.joe.springbootRest.controller;

import com.joe.springbootRest.entity.Employee;
import com.joe.springbootRest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("employees/{employeeId}")
    public Employee findById(@PathVariable int id){
        Employee employee= employeeService.findById(id);
        if (employee== null){
            throw new RuntimeException("Employee id not found - "+ id);
        }
        return employee;
    }

    @PostMapping("employees")
    public Employee save(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("employees/{employeeId}")
    public String deleteEmployee (@PathVariable int id){
        Employee employee =employeeService.findById(id);
        if (employee==null){
            throw new RuntimeException("EmployeeId not found- "+id);
        }
        employeeService.deleteById(id);
        return  "Deleted employee id- "+ id;
    }


    @GetMapping ("employeelist")
    public List<Employee> findAList( @RequestParam Map<String,String> employeeQuery){
        return employeeService.findAList(employeeQuery);

    }

}
