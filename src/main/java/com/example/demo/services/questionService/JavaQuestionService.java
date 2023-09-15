package com.example.demo.services.questionService;

import com.example.demo.models.Question;
import com.example.demo.services.examinerService.exception.onIllegalArgumentException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions;
    private final Random rnd = new Random();

    public JavaQuestionService(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {

        if (question.equals(answer)) {
            throw new onIllegalArgumentException("Вопрос совпадает с ответом");
        }

        Question temp = new Question(question, answer);

        if (this.questions.contains(temp)) {
            throw new onIllegalArgumentException("В базе уже существует такой вопрос");
        }
        this.questions.add(temp);
        return temp;
    }

    @Override
    public Question add(Question question) {
        this.questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new onIllegalArgumentException("Вопрос отсутствует в базе");
        }
        this.questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return this.questions;
    }

    @Override
    public Question getRandomQuestion() {
        int iterator = 0;
        int randNum = rnd.nextInt(this.questions.size());
        for (Question q : questions) {
            if (iterator == randNum) {
                return q;
            }
            iterator++;
        }
        return null;
    }
}
