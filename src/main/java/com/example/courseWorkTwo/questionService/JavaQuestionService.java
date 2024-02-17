package com.example.courseWorkTwo.questionService;

import com.example.courseWorkTwo.javaRepositories.QuestionRepository;
import com.example.courseWorkTwo.question.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("javaService")
public class JavaQuestionService implements QuestionService{

    private final QuestionRepository questionRepository;

    private Random random = new Random();


    public JavaQuestionService(@Qualifier("javaRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public boolean add(String question, String answer) {
        Question newQuestion = new Question(question, answer);

        return questionRepository.add(newQuestion);
    }

    @Override
    public boolean add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public boolean remove(String question, String answer) {
        Question newQuestion = new Question(question, answer);

        return questionRepository.remove(newQuestion);
    }

    @Override
    public boolean remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questionRepository.getAll());
    }

    @Override
    public Question getRandomQuestion() {
        return List.copyOf(questionRepository.getAll()).get(random.nextInt(questionRepository.getAll().size()));
    }

    @Override
    public int getSize() {
        return questionRepository.getAll().size();
    }
}
