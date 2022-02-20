package ru.matveykenya.springdaohibernate.repository;

import ru.matveykenya.springdaohibernate.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    EntityManager entityManager;

    public List<?> getPersonsByCity(String city) {
        String sqlQuery = "select p from Person p where p.cityOfLiving = :city";
        Query query = entityManager.createQuery(sqlQuery,Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }
}
