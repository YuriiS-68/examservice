package pro.sky.examservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.examservice.exception.QuestionAlreadyExistException;
import pro.sky.examservice.exception.QuestionIsNotFoundException;
import pro.sky.examservice.model.Question;
import pro.sky.examservice.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final Set<Question> javaQuestions;

    public JavaQuestionServiceImpl() {
        this.javaQuestions = new HashSet<>();
    }

    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (isQuestionExist(newQuestion)){
            throw new QuestionAlreadyExistException("This question " + newQuestion + " already in the collection.");
        }
        javaQuestions.add(newQuestion);
        return newQuestion;
    }

    public Question add(Question question) {
        if (isQuestionExist(question)){
            throw new QuestionAlreadyExistException("This question " + question + " already in the collection.");
        }
        javaQuestions.add(question);
        return question;
    }

    public Question remove(Question question) {
        if (!isQuestionExist(question)){
            throw new QuestionIsNotFoundException("This question " + question + " was not found.");
        }
        javaQuestions.removeIf(question1 -> question1.equals(question));
        return question;
    }

    public Collection<Question> getAll() {
        return javaQuestions;
    }

    public Question getRandomQuestion() {
        ArrayList<Question> arrayQuestions = new ArrayList<>(javaQuestions);
        return arrayQuestions.get(getRandomIndex());
    }

    private int getRandomIndex(){
        int randomIndex;
        Random random = new Random();
        randomIndex = random.nextInt(javaQuestions.size() - 1);
        return randomIndex;
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
