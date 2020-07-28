package com.joe.springbootRest.dao;

import com.joe.springbootRest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDaoJPAImpl implements EmployeeDao  {
    //define field for entityManager
    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public EmployeeDaoJPAImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        Query theQuery = entityManager.createQuery("from Employee");

        //execute query and get resultlist
        List<Employee> employeeList = theQuery.getResultList();

        // return the result
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Employee employee=entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee employee) {

        Employee theEmployee=entityManager.merge(employee);
        employee.setId(theEmployee.getId());
    }

    @Override
    public void deleteById(int id) {

        Query query= entityManager.createQuery(
                "delete from Employee where id=:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();

    }



    @Override
    @Transactional
    public List<Employee> findAList(Map<String,String> employeeQuery) {
        Integer id = Integer.valueOf(employeeQuery.get("id"));
        Query theQuery = entityManager.createQuery("from Employee where id > :employeeId AND firstName= :employeeName");
        theQuery.setParameter("employeeId",id);
        theQuery.setParameter("employeeName",employeeQuery.get("name"));
        List<Employee> employeeList = theQuery.getResultList();
        return employeeList;
    }
}
