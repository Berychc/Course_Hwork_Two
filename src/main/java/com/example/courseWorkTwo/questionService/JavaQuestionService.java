package com.example.courseWorkTwo.questionService;

import com.example.courseWorkTwo.question.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    private final Set<Question> questions = new HashSet<>();

    private Random random = new Random();

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public boolean add(String question, String answer) {
        Question newQuestion = new Question(question, answer);

        return questions.add(newQuestion);
    }

    @Override
    public boolean remove(String question, String answer) {
        Question newQuestion = new Question(question, answer);

        return questions.remove(newQuestion);
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return List.copyOf(questions).get(random.nextInt(questions.size()));
    }

    @Override
    public int getSize() {
        return questions.size();
    }
}
