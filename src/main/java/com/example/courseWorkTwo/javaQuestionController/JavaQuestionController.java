package com.example.courseWorkTwo.javaQuestionController;

import com.example.courseWorkTwo.question.Question;
import com.example.courseWorkTwo.questionService.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public void addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        service.add(question, answer);
    }

    @GetMapping("/remove")
    public void removeQuestion(@RequestParam("question") String question,
                                            @RequestParam("answer") String answer) {
        service.remove(question, answer);
    }

    @GetMapping("/find")
    public Collection<Question> getAllQuestion() {
        return service.getAll();
    }
}
