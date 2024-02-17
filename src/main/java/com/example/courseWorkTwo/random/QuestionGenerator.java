package com.example.courseWorkTwo.random;

import com.example.courseWorkTwo.questionService.QuestionService;

import java.util.Random;

public class QuestionGenerator {

    private Random random;

    public QuestionGenerator() {
        this.random = new Random();
    }

    public int getRandomQuestion(int maxNumber) {
        return random.nextInt(maxNumber);
    }

}
