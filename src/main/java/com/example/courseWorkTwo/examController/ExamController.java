package com.example.courseWorkTwo.examController;

import com.example.courseWorkTwo.examinerService.ExaminerService;
import com.example.courseWorkTwo.question.Question;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class ExamController {

    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }

    public Collection<Question> getQuestions(@RequestParam int amount) {
        return service.getQuestions(amount);
    }
}
