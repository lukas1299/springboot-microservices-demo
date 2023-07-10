package com.example.postservice.controller;

import com.example.postservice.model.Person;
import com.example.postservice.model.PersonRequest;
import com.example.postservice.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody PersonRequest personRequest){

        Person person = Person.builder()
                .name(personRequest.name())
                .email(personRequest.email())
                .age(personRequest.age())
                .build();

        return ResponseEntity.ok(personRepository.save(person));
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons(){
        return ResponseEntity.ok(personRepository.findAll());
    }
}
