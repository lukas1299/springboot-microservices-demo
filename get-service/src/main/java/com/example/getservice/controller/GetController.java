package com.example.getservice.controller;

import com.example.getservice.PersonRepository;
import com.example.getservice.model.Person;
import com.example.getservice.util.PersonServiceUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/fetched-persons")
public class GetController {

    private final PersonServiceUtil personServiceUtil;
    private final PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<List<Person>> fetchPersons(){
        return ResponseEntity.ok(personRepository.saveAll(personServiceUtil.getAllPersons()));
    }
}
