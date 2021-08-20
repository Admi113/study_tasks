package ru.diasoft.study_tasks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.diasoft.study_tasks.model.Greeting;
import ru.diasoft.study_tasks.model.GreetingDTO;

import java.util.List;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

//    @Query("SELECT DISTINCT g FROM Greeting g WHERE " +
//            "g.content = :content")
//    Greeting getByContent(@Param("content") String content);


    @Query("SELECT NEW ru.diasoft.study_tasks.model.GreetingDTO(" +
            "g.id," +
            "g.content)" +
            "FROM Greeting g")
    List<GreetingDTO> findAllDTO();
}
