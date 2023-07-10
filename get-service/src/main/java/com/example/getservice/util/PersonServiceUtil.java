package com.example.getservice.util;

import com.example.getservice.model.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "post-service")
public interface PersonServiceUtil {

    @GetMapping("/persons")
    List<Person> getAllPersons();
}
