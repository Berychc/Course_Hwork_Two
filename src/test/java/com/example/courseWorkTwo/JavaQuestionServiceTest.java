package com.example.courseWorkTwo;

import com.example.courseWorkTwo.questionService.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Random;

import static com.example.courseWorkTwo.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    private final JavaQuestionService service = new JavaQuestionService();

    @Test
    public void addQuestionTest() {
        service.add(QUESTION1, ANSWER1);

        assertTrue(service.getAll().contains(FULL_QUESTION1));
    }

    @Test
    public void removeQuestionTest() {
        service.remove(QUESTION1, ANSWER1);

        assertFalse(service.getAll().contains(FULL_QUESTION1));
    }

    @Test
    public void getAllTest() {
        service.add(QUESTION1, ANSWER1);
        service.add(QUESTION2, ANSWER2);
        service.add(QUESTION3, ANSWER3);

        assertTrue(service.getAll().containsAll(List.of(FULL_QUESTION1, FULL_QUESTION2, FULL_QUESTION3)));
    }

    @Test
    public void getRandomQuestionTest() {
        service.add(QUESTION1, ANSWER1);
        service.add(QUESTION2, ANSWER2);

        Random random = mock(Random.class, withSettings().withoutAnnotations());
        when(random.nextInt(anyInt())).thenReturn(1);

        service.setRandom(random);
        assertEquals(FULL_QUESTION1, service.getRandomQuestion());
    }
}
