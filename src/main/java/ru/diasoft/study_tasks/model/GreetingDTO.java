package ru.diasoft.study_tasks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GreetingDTO {
    private  Long id;
    private  String content;

}
