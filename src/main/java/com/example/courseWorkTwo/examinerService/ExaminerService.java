package com.example.courseWorkTwo.examinerService;

import com.example.courseWorkTwo.question.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
