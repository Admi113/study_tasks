package ru.diasoft.study_tasks.services.interfaces;

import ru.diasoft.study_tasks.model.Greeting;
import ru.diasoft.study_tasks.model.GreetingDTO;

import java.util.List;

public interface GreetingService {
    List<GreetingDTO> getAll();

    Greeting getById(Long id);

     void update(Greeting greeting);

    void deleteById(Long id);



}
