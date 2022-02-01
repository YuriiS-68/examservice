package pro.sky.examservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.examservice.model.Question;
import pro.sky.examservice.service.impl.ExamServiceImpl;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExamServiceImpl examinerService;

    public ExamController(ExamServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @RequestMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") Integer amount){
        return examinerService.getQuestions(amount);
    }
}
