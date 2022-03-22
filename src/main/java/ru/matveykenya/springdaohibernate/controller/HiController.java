package ru.matveykenya.springdaohibernate.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @GetMapping("/hi")
    public String getString(){
        return "Hi";
    }

    @GetMapping("/registered-user-hi")
    @PreAuthorize("#userName == authentication.principal.username")
    public String getString(@RequestParam String userName){
        return "Hi " + userName;
    }
}
