package ru.matveykenya.springdaohibernate.service;

import ru.matveykenya.springdaohibernate.entity.Person;
import ru.matveykenya.springdaohibernate.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<?> getPersonsByCity(String city){
        return repository.getPersonsByCity(city);
    }
}
