package com.example.demo.services.examinerService;

import com.example.demo.models.Question;
import com.example.demo.services.questionService.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    Set<Question> qss;


    Question question1 = new Question("a", "b");
    Question question2 = new Question("a", "c");
    Question question3 = new Question("a", "d");

    @BeforeEach
    void init(){
        qss = Set.of(question1, question2, question3);
    }



    @Test
    void getQuestions() {
        when(questionService.getAll()).thenReturn(qss);
        when(questionService.getRandomQuestion()).thenReturn(question1).thenReturn(question2).thenReturn(question3);

        Collection<Question> actual = examinerService.getQuestions(3);

        assertEquals(qss, actual);
        assertEquals(qss.size(), actual.size());
    }
}