package pro.sky.examservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.examservice.exception.QuestionLimitException;
import pro.sky.examservice.model.Question;
import pro.sky.examservice.service.impl.ExamServiceImpl;
import pro.sky.examservice.service.impl.JavaQuestionServiceImpl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.examservice.QuestionServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class ExamServiceTest {
    @Mock
    private JavaQuestionServiceImpl javaQuestionService;

    @InjectMocks
    private ExamServiceImpl out;

    private final Set<Question> testQuestions = new HashSet<>();

    public static Stream<Arguments> provideParamsForTest(){
        return Stream.of(Arguments.of(AMOUNT_BIGGER_THAN_SIZE_COLLECTION),
                Arguments.of(AMOUNT_LESS_THAN_ZERO));
    }

    @BeforeEach
    void srtUp(){
        out = new ExamServiceImpl(javaQuestionService);
        when(javaQuestionService.getAll()).thenReturn(BOOK_QUESTIONS);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    void shouldBeThrowsQuestionLimitExceptionWhenAmountBiggerOrLessThanSize(Integer amount){
        assertThrows(QuestionLimitException.class, () -> out.getQuestions(amount));
    }

    @Test
    void shouldGetQuestionsWhenAmountEqualsSizeOfCollection(){
        testQuestions.add(QUESTION1);
        testQuestions.add(QUESTION2);
        testQuestions.add(QUESTION3);
        testQuestions.add(QUESTION4);
        assertTrue(out.getQuestions(AMOUNT_EQUALS_SIZE).size() == testQuestions.size()
                && out.getQuestions(AMOUNT_EQUALS_SIZE).containsAll(testQuestions)
                && testQuestions.containsAll(out.getQuestions(AMOUNT_EQUALS_SIZE)));
    }
}
