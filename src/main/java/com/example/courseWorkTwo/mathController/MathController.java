package com.example.courseWorkTwo.mathController;

import com.example.courseWorkTwo.question.Question;
import com.example.courseWorkTwo.questionService.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathController {

    private final QuestionService service;

    public MathController(@Qualifier("mathService") QuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public boolean addQuestion(@RequestParam String question,
                               @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public boolean removeQuestion(@RequestParam String question,
                               @RequestParam String answer) {
        return service.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> getQuestion() {
        return service.getAll();
    }
}
