package com.example.courseWorkTwo.examController;

import com.example.courseWorkTwo.examinerService.ExaminerService;
import com.example.courseWorkTwo.question.Question;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return service.getQuestions(amount);
    }
}
