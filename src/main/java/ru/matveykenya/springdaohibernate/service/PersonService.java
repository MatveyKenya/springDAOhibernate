package ru.matveykenya.springdaohibernate.service;

import org.springframework.stereotype.Service;
import ru.matveykenya.springdaohibernate.entity.Person;
import ru.matveykenya.springdaohibernate.repository.PersonRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city){
        return repository.findAllByCityOfLiving(city);
    }

    public List<Person> getPersonsByAgeLessThen(int age) {
        return repository.findAllByAgeLessThanOrderByAge(age);
    }

    public Optional<List<Person>> getPersonsByNameAndSurname(String name, String surname) {
        return repository.findByNameAndSurname(name, surname);
    }

    public Optional<Person> getPersonById(Long id) {
        return repository.findById(id);
    }

    public Person createPerson(String name, String surname, int age, String phoneNumber, String cityOfLiving) {
        var person = Person.builder()
                .name(name)
                .surname(surname)
                .age(age)
                .phoneNumber(phoneNumber)
                .cityOfLiving(cityOfLiving)
                .build();
        return repository.save(person);
    }

    public Person deletePersonById(Long id) {
        var person = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found Id = " + id));
        repository.deleteById(id);
        return person;
    }

    public Person updatePersonByQuery(Long id, String name, String surname, int age, String phoneNumber, String cityOfLiving) {
        repository.updatePersonByQuery(id, name, surname, age, phoneNumber, cityOfLiving);
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found Id = " + id));
    }

    public Person updatePerson(Long id, String name, String surname, int age, String phoneNumber, String cityOfLiving){
        var person = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found Id = " + id));
        person.setName(name);
        person.setSurname(surname);
        person.setAge(age);
        person.setPhoneNumber(phoneNumber);
        person.setCityOfLiving(cityOfLiving);
        repository.save(person);
        return person;
    }
}

