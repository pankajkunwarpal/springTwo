package com.example.ss.boot.dao;

import com.example.ss.boot.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOInfo implements EmployeeDao{


    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOInfo(EntityManager manager) {
        entityManager = manager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

        return query.getResultList();
    }
}
