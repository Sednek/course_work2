package com.example.demo.repository;

import com.example.demo.models.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository{
    private final Set<Question> questions;

    public MathQuestionRepository(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {

        if (question.equals(answer)) {
            throw new IllegalArgumentException("Вопрос совпадает с ответом");
        }

        Question temp = new Question(question, answer);

        if (this.questions.contains(temp)) {
            throw new IllegalArgumentException("В базе уже существует такой вопрос");
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
            throw new IllegalArgumentException("Вопрос отсутствует в базе");
        }
        this.questions.remove(question);
        return question;
    }

    @Override
    @PostConstruct
    public void init() {
        add("aMath", "bMath");
        add("aMath", "cMath");
        add("aMath", "dMath");
        add("aMath", "eMath");

    }

    @Override
    public Collection<Question> getAll() {
        return this.questions;
    }
}
