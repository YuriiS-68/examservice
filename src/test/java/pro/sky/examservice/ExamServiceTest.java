package pro.sky.examservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.examservice.exception.QuestionLimitException;
import pro.sky.examservice.service.impl.ExamServiceImpl;
import pro.sky.examservice.service.impl.JavaQuestionServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static pro.sky.examservice.QuestionServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class ExamServiceTest {
    @Mock
    private JavaQuestionServiceImpl javaQuestionService;

    @InjectMocks
    private ExamServiceImpl out;

    @BeforeEach
    void srtUp(){
        out = new ExamServiceImpl(javaQuestionService);
        when(javaQuestionService.getAll()).thenReturn(BOOK_QUESTIONS);
    }

    @Test
    void shouldBeThrowsQuestionLimitExceptionWhenAmountBiggerThanSizeCollection(){
        assertThrows(QuestionLimitException.class, () -> out.getQuestions(AMOUNT_BIGGER_THAN_SIZE_COLLECTION));
    }

    @Test
    void shouldBeThrowsQuestionLimitExceptionWhenAmountLessThanZero(){
        assertThrows(QuestionLimitException.class, () -> out.getQuestions(AMOUNT_LESS_THAN_ZERO));
    }
}
