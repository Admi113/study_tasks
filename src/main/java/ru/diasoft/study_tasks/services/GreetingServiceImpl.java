package ru.diasoft.study_tasks.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diasoft.study_tasks.model.Greeting;
import ru.diasoft.study_tasks.model.GreetingDTO;
import ru.diasoft.study_tasks.repositories.GreetingRepository;
import ru.diasoft.study_tasks.services.interfaces.GreetingService;

import javax.transaction.Transactional;
import java.util.List;


@Service
@AllArgsConstructor
@Transactional
public class GreetingServiceImpl implements GreetingService {

    private final GreetingRepository greetingRepository;

    @Override
    public List<GreetingDTO> getAll() {
        return greetingRepository.findAllDTO();
    }

    @Override
    public Greeting getById(Long id) {
        return greetingRepository.getOne(id);
    }

    @Override
    public void update(Greeting greeting) {
        greetingRepository.save(greeting);
    }

    @Override
    public void deleteById(Long id) {
        greetingRepository.deleteById(id);
    }

}
