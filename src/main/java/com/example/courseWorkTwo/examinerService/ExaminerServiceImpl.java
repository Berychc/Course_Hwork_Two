package com.example.courseWorkTwo.examinerService;

import com.example.courseWorkTwo.question.Question;
import com.example.courseWorkTwo.questionService.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    @Autowired
    private final Question question;

    @Autowired
    private final QuestionService questionService;

    public ExaminerServiceImpl(Question question, QuestionService questionService) {
        this.question = question;
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        return questionService.getAll().stream()
                .limit(amount).collect(Collectors.toList());
    }
}
