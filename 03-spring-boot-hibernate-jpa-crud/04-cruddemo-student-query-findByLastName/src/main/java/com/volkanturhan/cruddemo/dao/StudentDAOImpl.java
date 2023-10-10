package com.volkanturhan.cruddemo.dao;

import com.volkanturhan.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {
    // define field for entity manager
    private final EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        // create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName desc",Student.class);
        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theData",Student.class);
        // set query parameters
        theQuery.setParameter("theData",lastName);
        // return query results
        return theQuery.getResultList();
    }
}