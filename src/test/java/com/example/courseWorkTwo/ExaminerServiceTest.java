package com.example.courseWorkTwo;

import com.example.courseWorkTwo.examinerService.ExaminerService;
import com.example.courseWorkTwo.examinerService.ExaminerServiceImpl;
import com.example.courseWorkTwo.questionService.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.courseWorkTwo.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    QuestionService questionMock;

    @InjectMocks
    ExaminerServiceImpl service;

    @Test
    public void getQuestionsTest() {

        when(questionMock.getSize()).thenReturn(1);

        when(questionMock.getRandomQuestion()).thenReturn(FULL_QUESTION1);

        assertEquals(TEST_QUESTIONS2, service.getQuestions(1));
    }

}
