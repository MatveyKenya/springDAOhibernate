package ru.matveykenya.springdaohibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.matveykenya.springdaohibernate.entity.Person;
import ru.matveykenya.springdaohibernate.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class Controller {

    private final PersonService service;

    public Controller(PersonService service) {
        this.service = service;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city){
        return service.getPersonsByCity(city);
    }

}
