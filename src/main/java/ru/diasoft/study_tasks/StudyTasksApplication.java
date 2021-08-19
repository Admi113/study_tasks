package ru.diasoft.study_tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class StudyTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyTasksApplication.class, args);
    }

}
