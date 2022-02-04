package pro.sky.examservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.examservice.exception.QuestionLimitException;
import pro.sky.examservice.model.Question;
import pro.sky.examservice.service.ExamService;

import java.util.*;

@Service
public class ExamServiceImpl implements ExamService {

    private final JavaQuestionServiceImpl javaQuestionService;
    private final MathQuestionServiceImpl mathQuestionService;
    private final Random random = new Random();

    public ExamServiceImpl(JavaQuestionServiceImpl javaQuestionService, MathQuestionServiceImpl mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int sizeGeneral = javaQuestionService.getAll().size() + mathQuestionService.getAll().size();
        if (amount > sizeGeneral || amount < 1){
            throw new QuestionLimitException("Question limit exceeded");
        }

        if (amount == sizeGeneral){
            Set<Question> setQuestions = new HashSet<>(javaQuestionService.getAll());
            setQuestions.addAll(mathQuestionService.getAll());
            return setQuestions;
        }

        int amountForJava = getRandomRange(amount);

        Set<Question> setQuestions = new HashSet<>();

        if (amount == 1){
            putQuestionRandom(setQuestions);
        }

        while (setQuestions.size() < amountForJava){
            setQuestions.add(javaQuestionService.getRandomQuestion());
        }
        while (setQuestions.size() < amount){
            setQuestions.add(mathQuestionService.getRandomQuestion());
        }
        return setQuestions;
    }

    private void putQuestion(Set<Question> questions, Question question){
        int sizeAfterAdd = questions.size() + 1;

        while (questions.size() != sizeAfterAdd){
            questions.add(question);
        }
    }

    private void putQuestionRandom(Set<Question> questions){
        if (random.nextInt(2) == 0){
            putQuestion(questions, mathQuestionService.getRandomQuestion());
        }
        else {
            putQuestion(questions, javaQuestionService.getRandomQuestion());
        }
    }

    private int getRandomRange(int amount){
        int min = 1;
        int numberQuestions;
        numberQuestions = random.nextInt((amount + 1) - min) + 1;
        return numberQuestions;
    }
}
