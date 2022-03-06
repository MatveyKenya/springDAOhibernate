package ru.matveykenya.springdaohibernate.repository;

import org.springframework.stereotype.Repository;
import ru.matveykenya.springdaohibernate.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        String sqlQuery = "select p from Person p where p.cityOfLiving = :city";
        TypedQuery<Person> query = entityManager.createQuery(sqlQuery,Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }
}
