package com.example.demo.services.examinerService;

import com.example.demo.models.Question;
import com.example.demo.services.examinerService.exception.BadRequestException;
import com.example.demo.services.questionService.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {


    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> listOfQuestions = new HashSet<>();
        if (amount > questionService.getAll().size()) {
            System.out.println(amount);
            System.out.println(questionService.getAll().size());
            throw new BadRequestException("Указанное количество вопросов превышает количество вопросов в базе");
        }
        while(listOfQuestions.size() != amount) {
            listOfQuestions.add(questionService.getRandomQuestion());
        }
        return listOfQuestions;
    }

}
