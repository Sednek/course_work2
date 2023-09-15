package com.example.demo.controller;

import com.example.demo.models.Question;
import com.example.demo.services.examinerService.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/examination/Java")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/getQuestions")
    public Collection<Question> getQuestions(@RequestParam(value = "amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
