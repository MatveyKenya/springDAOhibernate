package ru.matveykenya.springdaohibernate.controller;

import org.springframework.web.bind.annotation.*;
import ru.matveykenya.springdaohibernate.entity.Person;
import ru.matveykenya.springdaohibernate.service.PersonService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class Controller {

    private final PersonService service;

    public Controller(PersonService service) {
        this.service = service;
    }

    // возвращает Entity по городу
    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city){
        return service.getPersonsByCity(city);
    }

    //принимать возраст(age) и возвращать Entity из базы данных,
    // которые меньше переданного age и отсортированы по возрастанию
    @GetMapping("/by-age-less-then")
    public List<Person> getPersonsByAgeLessThen(@RequestParam int age) {
        return service.getPersonsByAgeLessThen(age);
    }

    //принимать имя и фамилию(name и surname) и возвращать Entity из базы данных,
    // которые соответствуют сочетанию name и surname и является Optional
    @GetMapping("/name-and-surname")
    public List<Person> getPersonsByAgeLessThen(@RequestParam String name, @RequestParam String surname) {
        return service.getPersonsByNameAndSurname(name, surname)
                .orElseThrow(() -> new EntityNotFoundException("not found " + name + " " + surname));
    }

    @GetMapping("/by-id")
    public Person getPersonById(@RequestParam Long id){
        return service.getPersonById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found Id = " + id));
    }

    //создание Person
    @PostMapping("/create")
    public Person createPerson(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam int age,
            @RequestParam String phoneNumber,
            @RequestParam String cityOfLiving) {
        return service.createPerson(name, surname, age, phoneNumber, cityOfLiving);
    }

    @DeleteMapping("/delete")
    public Person deletePersonById(@RequestParam Long id){
        return service.deletePersonById(id);
    }

    @PutMapping("/update")
    public Person updatePerson(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam int age,
            @RequestParam String phoneNumber,
            @RequestParam String cityOfLiving
    ) {
        return service.updatePerson(id, name, surname, age, phoneNumber, cityOfLiving);
    }
}
