package com.example.courseWorkTwo.javaRepositories;

import com.example.courseWorkTwo.question.Question;

import java.util.Collection;

public interface QuestionRepository {
    boolean add(Question question);

    boolean remove(Question question);

    Collection<Question> getAll();
}
