package com.example.courseWorkTwo.examinerService;

import com.example.courseWorkTwo.question.Question;
import com.example.courseWorkTwo.questionService.QuestionService;
import com.example.courseWorkTwo.questionsException.QuestionsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private static final Logger logger = LoggerFactory.getLogger(ExaminerServiceImpl.class);

    private final QuestionService javaService;

    private final QuestionService mathService;

    Random random = new Random();

    public void setRandom(Random random) {
        this.random = random;
    }

    public ExaminerServiceImpl(@Qualifier("javaService") QuestionService javaService,
                               @Qualifier("mathService") QuestionService mathService) {
        this.javaService = javaService;
        this.mathService = mathService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<QuestionService> serviceList = List.of(javaService, mathService);

        int size = serviceList.stream().mapToInt(QuestionService::getSize).sum();
        if (amount <= 0 || size < amount) {
            logger.error("Неправильная запрошенная сумма" + size);
            throw new QuestionsException(amount, size);
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(serviceList.get(random.nextInt(serviceList.size())).getRandomQuestion());
        }
        return questions;
    }
}
