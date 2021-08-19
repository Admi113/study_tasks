package ru.diasoft.study_tasks.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.diasoft.study_tasks.exceptins.NotFoundExceptions;
import ru.diasoft.study_tasks.model.Greeting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("greeting")
public class GreetingController {

    private static final String temp = "Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();

    private static final List<Greeting> listOfGreeting = new ArrayList<>();

    @GetMapping

    public List<Greeting> getAllGreetings() {
        return listOfGreeting;
    }

    @GetMapping("{id}")
    public Greeting getOne(@PathVariable Long id) {
        return getById(id);
    }

    @PostMapping
    public ResponseEntity<Greeting> create(@RequestBody JsonNode content)  {

        String s = content.findValuesAsText("content").get(0);
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(temp, s));
        listOfGreeting.add(greeting);
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Greeting> update(@PathVariable long id, @RequestBody Greeting greeting) {

        Greeting greetingToChange = listOfGreeting
                .remove(listOfGreeting.indexOf(getById(id)));
        greetingToChange.setContent(greeting.getContent());
        greetingToChange.setId(greeting.getId());
        listOfGreeting.add(greetingToChange);
        return new ResponseEntity<>(greeting, HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        Greeting greeting = getById(id);
        listOfGreeting.remove(greeting);
    }


    private static Greeting getById(Long id) {
        return listOfGreeting.stream().filter(data -> data.getId() == id)
                .findFirst().orElseThrow(NotFoundExceptions::new);
    }
}

