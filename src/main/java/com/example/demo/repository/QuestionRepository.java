package com.example.demo.repository;

import com.example.demo.models.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    void init();

    Collection<Question> getAll();

}
