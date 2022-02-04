package pro.sky.examservice.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.examservice.model.Question;
import pro.sky.examservice.service.impl.MathQuestionServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {
    private final MathQuestionServiceImpl mathQuestionService;

    public MathQuestionController(MathQuestionServiceImpl mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/add")
    public String add(@RequestParam(value = "question") String question,
                      @RequestParam(value = "answer") String answer){
        mathQuestionService.add(question, answer);
        return "Question added success";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam(value = "question") String question,
                         @RequestParam(value = "answer") String answer){
        Question questionForDelete = new Question(question, answer);
        mathQuestionService.remove(questionForDelete);
        return "Question removed success";
    }

    @GetMapping("/get")
    public Collection<Question> getAll(){
        return mathQuestionService.getAll();
    }
}
