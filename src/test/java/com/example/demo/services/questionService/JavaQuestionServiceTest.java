package com.example.demo.services.questionService;

import com.example.demo.models.Question;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JavaQuestionServiceTest {

    Question q = new Question("a", "b");

    private final Set<Question> questions = new HashSet<>();

    private final JavaQuestionService qs = new JavaQuestionService(questions);

    @Test
    void addQuestion_ReturnQuestion() {
        this.questions.clear();

        Question expected = qs.add("a", "b");


        assertEquals(expected, q);
        assertEquals(qs.getAll().size(), 1 );

    }

    @Test
    void remove() {
        this.questions.clear();

        qs.add("a", "b");
        qs.add("a", "c");

        Question test = new Question("a", "b");

        qs.remove(test);

        assertEquals(test, q);
        assertEquals(qs.getAll().size(), 1);




    }

    @Test
    void getAll() {
        qs.add(q);
        qs.add("a","c");

        Collection<Question> test = new HashSet<>();
        test.add(q);
        Question qtest = new Question("a", "c");
        test.add(qtest);

        assertEquals(qs.getAll(), test);
    }
}