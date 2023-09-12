package com.example.demo.controller;

import com.example.demo.models.Question;
import com.example.demo.services.examinerService.ExaminerService;
import com.example.demo.services.examinerService.exception.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/examination/Java")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/getQuestions")
    public Collection<Question> getQuestions(@RequestParam(value = "amount") int amount) {
        try {
            return examinerService.getQuestions(amount);
        } catch (BadRequestException e) {
            Set<Question> err = new HashSet<>();
            Question q = new Question(e.getMessage(), e.getMessage());
            err.add(q);
            return err;
        }
    }


}
