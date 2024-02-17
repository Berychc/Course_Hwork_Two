package com.example.courseWorkTwo;

import com.example.courseWorkTwo.examinerService.ExaminerServiceImpl;
import com.example.courseWorkTwo.question.Question;
import com.example.courseWorkTwo.questionService.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    private final QuestionService javaServiceMock = mock(QuestionService.class);

    private final QuestionService mathServiceMock = mock(QuestionService.class);

    private final ExaminerServiceImpl service = new ExaminerServiceImpl(javaServiceMock, mathServiceMock);

    @Test
    public void getRandomTest() {
        when(javaServiceMock.getRandomQuestion()).thenReturn(
                new Question("Привет", "Пока"),
                new Question("Приве1", "Пока1"));

        when(mathServiceMock.getRandomQuestion()).thenReturn(
                new Question("Привет", "Пока"),
                new Question("Приве1", "Пока1"));

        when(javaServiceMock.getSize()).thenReturn(2);
        when(mathServiceMock.getSize()).thenReturn(2);

        Random randomMock = mock(Random.class);
        when(randomMock.nextInt(anyInt())).thenReturn(0, 1, 1, 0);
        service.setRandom(randomMock);

        Collection<Question> actual = service.getQuestions(4);

        List<Question> expected = List.of(
                new Question("Привет", "Пока"),
                new Question("Привет1", "Пока1"),
                new Question("Привет2", "Пока2"),
                new Question("Приве3т", "Пока3"));

        Assertions.assertIterableEquals(expected, actual);
    }
}
