package pro.sky.examservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.examservice.exception.QuestionLimitException;
import pro.sky.examservice.model.Question;
import pro.sky.examservice.service.ExamService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExamServiceImpl implements ExamService {

    private final JavaQuestionServiceImpl javaQuestionService;

    public ExamServiceImpl(JavaQuestionServiceImpl javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size() || amount < 1){
            throw new QuestionLimitException("Question limit exceeded");
        }

        if (amount == javaQuestionService.getAll().size()){
            return javaQuestionService.getAll();
        }

        Set<Question> setQuestions = new HashSet<>();

        while (setQuestions.size() < amount){
            setQuestions.add(javaQuestionService.getRandomQuestion());
        }
        return setQuestions;
    }
}
