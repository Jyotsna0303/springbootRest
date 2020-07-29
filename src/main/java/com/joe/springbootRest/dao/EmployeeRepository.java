package com.joe.springbootRest.dao;

import com.joe.springbootRest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query("from Employee where id > ?1 AND firstName= ?2")
    List<Employee> findByIdAndFirstName(int id, String name);
}
