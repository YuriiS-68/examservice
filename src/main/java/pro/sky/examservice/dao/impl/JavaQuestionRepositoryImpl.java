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
public class JavaQuestionRepositoryImpl implements QuestionRepository {
    private final Set<Question> javaQuestions;

    public JavaQuestionRepositoryImpl() {
        this.javaQuestions = new HashSet<>();
    }

    @Override
    public Question add(Question question) {
        if (isQuestionExist(question)){
            throw new QuestionAlreadyExistException("This question " + question + " already in the collection.");
        }
        javaQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!isQuestionExist(question)){
            throw new QuestionIsNotFoundException("This question " + question + " was not found.");
        }
        javaQuestions.removeIf(question1 -> question1.equals(question));
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestions;
    }

    private boolean isQuestionExist(Question question){
        for (Question javaQuestion : javaQuestions) {
            if (javaQuestion.equals(question)){
                return true;
            }
        }
        return false;
    }
}
