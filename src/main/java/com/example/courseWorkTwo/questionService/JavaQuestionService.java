package com.example.courseWorkTwo.questionService;

import com.example.courseWorkTwo.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    @Autowired
    private final Set<Question> questions;

    public JavaQuestionService(Set<Question> questions) {
        this.questions = questions;
    }


    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);

        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {

        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question newQuestion = new Question(question, answer);

        questions.remove(newQuestion);
        return newQuestion;
    }

    @Override
    public Question remove(Question question) {

        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int listSize = questions.size();

        if (listSize > 0) {
            return getRandomQuestion();
        } else {
            return null;
        }
    }
}
