package com.example.demo.services.examinerService;

import com.example.demo.models.Question;
import com.example.demo.services.examinerService.exception.BadRequestException;
import com.example.demo.services.questionService.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<Question> listOfQuestions = new ArrayList<>();

    private final Random rnd = new Random();

    private final QuestionService javaQuestionService;

    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService, @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions() {
        listOfQuestions.clear();
        Question rndQuestion;

        int javaRnd = rnd.nextInt(4);
        int mathRnd = rnd.nextInt(4);

        if(javaRnd == 0 || mathRnd == 0){
            javaRnd++;
            mathRnd++;
        }

        for (int i = 0; i < javaRnd; i++) {
            rndQuestion = javaQuestionService.getRandomQuestion();
            if (!listOfQuestions.contains(rndQuestion)) {
                listOfQuestions.add(rndQuestion);
            } else {
                i--;
            }
        }

        for (int i = 0; i < mathRnd; i++) {
            rndQuestion = mathQuestionService.getRandomQuestion();
            if (!listOfQuestions.contains(rndQuestion)) {
                listOfQuestions.add(rndQuestion);
            } else {
                i--;
            }
        }
        return listOfQuestions;
    }
}
