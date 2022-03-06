package ru.matveykenya.springdaohibernate.service;

import org.springframework.stereotype.Service;
import ru.matveykenya.springdaohibernate.entity.Person;
import ru.matveykenya.springdaohibernate.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city){
        return repository.getPersonsByCity(city);
    }
}
