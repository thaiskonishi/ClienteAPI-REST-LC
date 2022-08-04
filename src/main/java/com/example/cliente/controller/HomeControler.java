package com.example.cliente.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControler {

    @GetMapping({ "/home" })
    public String home() {
        return "Homepage....";
    }

    // public User getUsers(){
    // return new User("Antonia", "antonio@gmail.com");
    // }

    @RequestMapping("/")
    public String hello() {
        return "HELLO WORLD";
    }
}
