package com.joe.springboot.crudhibernate.dao;

import com.joe.springboot.crudhibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;

import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    //define field for entityManager
    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        //create a query
        Query<Employee> theQuery = session.createQuery("from Employee", Employee.class);

        //execute query and get resultlist
        List<Employee> employeeList = theQuery.getResultList();

        // return the result
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Session session= entityManager.unwrap(Session.class);
        Employee employee=session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        Session session= entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query query= session.createQuery(
                "delete from Employee where id=:employeeId");
       query.setParameter("employeeId",id);
       query.executeUpdate();

    }



    @Override
    @Transactional
    public List<Employee> findAList(Map<String,String> employeeQuery) {
        Integer id = Integer.valueOf(employeeQuery.get("id"));
        Session session = entityManager.unwrap(Session.class);
        System.out.println("Jyotsna Message****************");
        Query theQuery = session.createQuery("from Employee where id > :employeeId AND firstName= :employeeName");
        theQuery.setParameter("employeeId",id);
        theQuery.setParameter("employeeName",employeeQuery.get("name"));
        List<Employee> employeeList = theQuery.list();
        System.out.println("Jyotsna Message 2****************"+employeeList);
        return employeeList;
    }
}