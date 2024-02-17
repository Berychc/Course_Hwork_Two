package com.example.courseWorkTwo.javaRepositories;

import com.example.courseWorkTwo.question.Question;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository("/javaRepository")
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;


    public JavaQuestionRepository() {
        questions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        add(new Question("Лучший наставник СкайПро?", "Оля"));
        add(new Question("Мотор М50?", "BMW"));
        add(new Question("Жор масла?", "Масло съемные колпачки"));
        add(new Question("Bmw m5", "E34"));
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
