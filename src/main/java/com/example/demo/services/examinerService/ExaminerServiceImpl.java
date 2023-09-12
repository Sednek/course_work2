package com.example.demo.services.examinerService;

import com.example.demo.models.Question;
import com.example.demo.services.examinerService.exception.BadRequestException;
import com.example.demo.services.questionService.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<Question> listOfQuestions = new ArrayList<>();

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        listOfQuestions.clear();
        Question rndQuestion;
        if (amount > questionService.getAll().size()) {
            System.out.println(amount);
            System.out.println(questionService.getAll().size());
            throw new BadRequestException("Указанное количество вопросов превышает количество вопросов в базе");
        }
        for (int i = 0; i < amount; i++) {
            rndQuestion = questionService.getRandomQuestion();
            if (!listOfQuestions.contains(rndQuestion)) {
                listOfQuestions.add(rndQuestion);
            } else {
                i--;
            }
        }
        return listOfQuestions;
    }

}
