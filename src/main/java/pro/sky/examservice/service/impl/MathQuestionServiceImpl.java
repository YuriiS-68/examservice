package pro.sky.examservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.examservice.dao.impl.MathQuestionRepositoryImpl;
import pro.sky.examservice.model.Question;
import pro.sky.examservice.service.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionServiceImpl implements QuestionService {
    private final MathQuestionRepositoryImpl questionRepository;

    public MathQuestionServiceImpl(MathQuestionRepositoryImpl questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        ArrayList<Question> arrayQuestions = new ArrayList<>(questionRepository.getAll());
        return arrayQuestions.get(getRandomIndex());
    }

    private int getRandomIndex(){
        int randomIndex;
        Random random = new Random();
        randomIndex = random.nextInt(questionRepository.getAll().size() - 1);
        return randomIndex;
    }
}
