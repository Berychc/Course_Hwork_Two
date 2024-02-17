package com.example.courseWorkTwo.mathService;

import com.example.courseWorkTwo.javaRepositories.QuestionRepository;
import com.example.courseWorkTwo.question.Question;
import com.example.courseWorkTwo.questionService.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service("mathService")
public class MathQuestionService implements QuestionService {

    private Random random = new Random();

    private final QuestionRepository questionRepository;

    public MathQuestionService(@Qualifier("mathRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
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
        return Collections.unmodifiableCollection(getAll());
    }

    @Override
    public Question getRandomQuestion() {
        if (random.nextBoolean()) {
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            return new Question("Сколько будет " + a + " + " + b + " ?", String.valueOf(a + b));
        } else {
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            return new Question("Сколько будет " + a + " - " + b + " ?", String.valueOf(a - b));
        }
    }

    @Override
    public int getSize() {
        return questionRepository.getAll().size();
    }
}
