package ru.matveykenya.springdaohibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.matveykenya.springdaohibernate.entity.Person;
import ru.matveykenya.springdaohibernate.service.Service;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/by-city")
    public List<?> getPersonsByCity(@RequestParam String city){
        return service.getPersonsByCity(city);
    }

}
