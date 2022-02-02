package pro.sky.examservice.service;

import pro.sky.examservice.model.Question;

import java.util.Collection;

public interface ExamService {
    Collection<Question> getQuestions(int amount);
}
