package com.example.courseWorkTwo;

import com.example.courseWorkTwo.question.Question;

import java.util.Set;

public class TestConstants {

    public static final String QUESTION1 = "Первый вопрос";

    public static final String QUESTION2 = "Второй вопрос";

    public static final String QUESTION3 = "Третий вопрос";

    public static final String ANSWER1 = "Первый ответ";

    public static final String ANSWER2 = "Первый ответ";

    public static final String ANSWER3 = "Первый ответ";

    public static final Question FULL_QUESTION1 = new Question(QUESTION1, ANSWER1);

    public static final Question FULL_QUESTION2 = new Question(QUESTION2, ANSWER2);

    public static final Question FULL_QUESTION3 = new Question(QUESTION3, ANSWER3);

    public static final Set<Question> TEST_QUESTIONS1 = Set.of(FULL_QUESTION1, FULL_QUESTION2, FULL_QUESTION3);

    public static final Set<Question> TEST_QUESTIONS2 = Set.of(FULL_QUESTION1);

}
