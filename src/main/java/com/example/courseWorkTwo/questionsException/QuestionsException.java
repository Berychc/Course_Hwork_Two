package com.example.courseWorkTwo.questionsException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionsException extends RuntimeException {
    public String QuestionsException() {
        return "Превышено максимальное количество вопросов";
    }
}
