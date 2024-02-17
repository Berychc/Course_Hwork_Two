package com.example.courseWorkTwo;

import com.example.courseWorkTwo.javaRepositories.JavaQuestionRepository;
import com.example.courseWorkTwo.question.Question;
import com.example.courseWorkTwo.questionService.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

   @Mock
   private JavaQuestionRepository repository;

   @InjectMocks
   private JavaQuestionService service;

    @Test
    public void addQuestionTest() {
        Question question = new Question("Привет", "Пока");
        when(repository.add(question)).thenReturn(true, false);

        assertTrue(service.add(question));
        assertFalse(service.add(question));

    }

    @Test
    public void removeQuestionTest() {
        Question question = new Question("Привет", "Пока");
        when(repository.remove(question)).thenReturn(true, false);

        assertTrue(service.remove(question));
        assertFalse(service.remove(question));
    }

    @Test
    public void getAllTest() {
        Set<Question> questionSet = Set.of(
                new Question("Привет", "Пока"),
                new Question("Привет1", "Пока1"));

        when(repository.getAll()).thenReturn(questionSet);
        assertTrue(service.getAll().containsAll(questionSet));
    }

    @Test
    public void getRandomQuestionTest() {
        Set<Question> questionSet = Set.of(
                new Question("Привет", "Пока"),
                new Question("Привет1", "Пока1"));

        when(repository.getAll()).thenReturn(questionSet);

        Random random = mock(Random.class, withSettings().withoutAnnotations());
        when(random.nextInt(anyInt())).thenReturn(0, 1);
        service.setRandom(random);

        assertEquals(new Question("Привет", "Пока"), service.getRandomQuestion());
        assertEquals(new Question("Привет1", "Пока1"), service.getRandomQuestion());

    }
}
