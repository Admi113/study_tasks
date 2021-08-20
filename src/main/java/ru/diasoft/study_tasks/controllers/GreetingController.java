package ru.diasoft.study_tasks.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diasoft.study_tasks.model.Greeting;
import ru.diasoft.study_tasks.model.GreetingDTO;
import ru.diasoft.study_tasks.services.interfaces.GreetingService;

import java.util.List;

@RestController
@RequestMapping("greetings")
@AllArgsConstructor
public class GreetingController {

    private final GreetingService service;

    @GetMapping
    public List<GreetingDTO> getAllGreetings() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public GreetingDTO getOne(@PathVariable Long id) {
        Greeting greeting = service.getById(id);
        return new GreetingDTO(greeting.getId(), greeting.getContent());
    }

    @PostMapping
    public ResponseEntity<GreetingDTO> create(@RequestBody Greeting greeting) {
        service.update(greeting);
        GreetingDTO dto = new GreetingDTO(greeting.getId(), greeting.getContent());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<GreetingDTO> update( @RequestBody Greeting greeting) {
        service.update(greeting);
        GreetingDTO dto = new GreetingDTO(greeting.getId(), greeting.getContent());
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }


}

