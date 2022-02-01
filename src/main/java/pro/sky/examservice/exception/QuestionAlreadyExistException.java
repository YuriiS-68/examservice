package pro.sky.examservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAlreadyExistException extends RuntimeException{
    public QuestionAlreadyExistException(String message){
        super();
    }
}
