package com.example.courseWorkTwo.javaRepositories;

import com.example.courseWorkTwo.question.Question;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository("mathRepository")
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public MathQuestionRepository() {
        questions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        add(new Question("2 + 2","5000"));
        add(new Question("4 + 4","8"));
        add(new Question("14 + 88","1488"));
    }

    public boolean add(Question question) {
        return questions.add(question);
    }

    public boolean remove(Question question) {
        return questions.remove(question);
    }

    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }
}
