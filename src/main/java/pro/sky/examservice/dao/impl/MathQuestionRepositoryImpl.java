package pro.sky.examservice.dao.impl;

import org.springframework.stereotype.Repository;
import pro.sky.examservice.dao.QuestionRepository;
import pro.sky.examservice.exception.QuestionAlreadyExistException;
import pro.sky.examservice.exception.QuestionIsNotFoundException;
import pro.sky.examservice.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepositoryImpl implements QuestionRepository {
    private final Set<Question> mathQuestions;

    public MathQuestionRepositoryImpl() {
        this.mathQuestions = new HashSet<>();
    }

    @Override
    public Question add(Question question) {
        if (isQuestionExist(question)){
            throw new QuestionAlreadyExistException("This question " + question + " already in the collection.");
        }
        mathQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!isQuestionExist(question)){
            throw new QuestionIsNotFoundException("This question " + question + " was not found.");
        }
        mathQuestions.removeIf(question1 -> question1.equals(question));
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestions;
    }

    private boolean isQuestionExist(Question question){
        for (Question mathQuestion : mathQuestions) {
            if (mathQuestion.equals(question)){
                return true;
            }
        }
        return false;
    }
}
