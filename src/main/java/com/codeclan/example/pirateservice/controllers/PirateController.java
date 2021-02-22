package com.codeclan.example.pirateservice.controllers;

import com.codeclan.example.pirateservice.models.Pirate;
import com.codeclan.example.pirateservice.repositories.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//annotation that defines that all the routes within this class are accessible in /pirates
@RestController
public class PirateController {
    //using dependency injection
    @Autowired
            //creates an instance
    PirateRepository pirateRepository;

    //map route to method
    @GetMapping(value = "/pirates")
    public List<Pirate> getAllPirates() {
        return pirateRepository.findAll();
    }

    //map {id} route
    @GetMapping(value = "/pirates/{id}")
                            //maps id here to id in route
    public Optional<Pirate> getPirate(@PathVariable Long id) {
        return pirateRepository.findById(id);
    }
}
