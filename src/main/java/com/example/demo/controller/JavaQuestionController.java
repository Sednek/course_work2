package com.example.demo.controller;

import com.example.demo.models.Question;
import com.example.demo.services.questionService.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/Java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam(value = "question") String question, @RequestParam(value = "answer") String answer) {
        try {
            return questionService.add(question, answer);
        } catch (IllegalArgumentException e) {
            return new Question(e.getMessage(), e.getMessage());
        }
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam(value = "question") String question, @RequestParam(value = "answer") String answer) {
        Question questionToRemove = new Question(question, answer);
        try {
            return questionService.remove(questionToRemove);
        } catch (IllegalArgumentException e) {
            return new Question(e.getMessage(), e.getMessage());
        }
    }
}
