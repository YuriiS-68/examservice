package pro.sky.examservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.examservice.exception.QuestionAlreadyExistException;
import pro.sky.examservice.exception.QuestionIsNotFoundException;
import pro.sky.examservice.model.Question;
import pro.sky.examservice.service.QuestionService;
import pro.sky.examservice.service.impl.JavaQuestionServiceImpl;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pro.sky.examservice.QuestionServiceTestConstants.*;

public class JavaQuestionServiceTest {
    private QuestionService out = new JavaQuestionServiceImpl();
    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;

    @BeforeEach
    void setUp(){
        question1 = new Question(FIRST_QUESTION, FIRST_ANSWER);
        question2 = new Question(SECOND_QUESTION, SECOND_ANSWER);
        question3 = new Question(THIRD_QUESTION, THIRD_ANSWER);
        question4 = new Question(FOURTH_QUESTION, FOURTH_ANSWER);
        out = new JavaQuestionServiceImpl();
        out.add(FIRST_QUESTION, FIRST_ANSWER);
        out.add(SECOND_QUESTION, SECOND_ANSWER);
        out.add(THIRD_QUESTION, THIRD_ANSWER);
    }

    @Test
    void addQuestionTest(){
        Collection<Question> expected = out.getAll();
        Collection<Question> actual = new ArrayList<>();
        actual.add(question1);
        actual.add(question2);
        actual.add(question3);
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    void shouldBeThrowsQuestionAlreadyExistExceptionWhenAddedQuestionAlreadyExist(){
        assertThrows(QuestionAlreadyExistException.class, () -> out.add(SECOND_QUESTION, SECOND_ANSWER));
    }

    @Test
    void shouldBeThrowsQuestionIsNotFoundExceptionWhenRemoveQuestion(){
        assertThrows(QuestionIsNotFoundException.class, () -> out.remove(question4));
    }

    @Test
    void removeQuestionTest(){
        Collection<Question> expected = out.getAll();
        Collection<Question> actual = new ArrayList<>();
        actual.add(question1);
        actual.add(question2);
        actual.add(question3);
        actual.add(question4);
        actual.remove(question4);

        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }
}
