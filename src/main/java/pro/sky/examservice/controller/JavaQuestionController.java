package pro.sky.examservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.examservice.model.Question;
import pro.sky.examservice.service.impl.JavaQuestionServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    private final JavaQuestionServiceImpl javaQuestionService;

    public JavaQuestionController(JavaQuestionServiceImpl javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }


    @GetMapping("/add")
    public String add(@RequestParam(value = "question") String question,
                      @RequestParam(value = "answer") String answer){
        javaQuestionService.add(question, answer);
        return "Question added success";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam(value = "question") String question,
                         @RequestParam(value = "answer") String answer){
        Question questionForDelete = new Question(question, answer);
        javaQuestionService.remove(questionForDelete);
        return "Question removed success";
    }

    @GetMapping("/get")
    public Collection<Question> getAll(){
        return javaQuestionService.getAll();
    }
}
