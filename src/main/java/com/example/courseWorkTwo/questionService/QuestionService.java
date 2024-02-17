package com.example.courseWorkTwo.questionService;

import com.example.courseWorkTwo.question.Question;

import java.util.Collection;

public interface QuestionService {

    boolean add(String question, String answer);

    boolean remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();

    int getSize();
}
