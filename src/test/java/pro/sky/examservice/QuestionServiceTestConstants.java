package pro.sky.examservice;

import pro.sky.examservice.model.Question;
import java.util.List;

import java.util.Collection;

public class QuestionServiceTestConstants {
    public static String FIRST_QUESTION = "Какой размер имеет тип int ? ";
    public static String FIRST_ANSWER = " 32 бит";

    public static String SECOND_QUESTION = "Какой размер имеет тип long ? ";
    public static String SECOND_ANSWER = " 64 бит";

    public static String THIRD_QUESTION = "Какой размер имеет тип short ? ";
    public static String THIRD_ANSWER = " 16 бит";

    public static String FOURTH_QUESTION = "Какой размер имеет тип byte ? ";
    public static String FOURTH_ANSWER = " 8 бит";

    public static final Question QUESTION1 = new Question("Какой размер имеет тип int ? ", " 32 бит");
    public static final Question QUESTION2 = new Question("Какой размер имеет тип short ? ", " 16 бит");
    public static final Question QUESTION3 = new Question("Какой размер имеет тип long ? ", " 64 бит");
    public static final Question QUESTION4 = new Question("Какой размер имеет тип byte ? ", " 8 бит");

    public static final Collection<Question> BOOK_QUESTIONS = List.of(
            new Question("Какой размер имеет тип int ? ", " 32 бит"),
            new Question("Какой размер имеет тип short ? ", " 16 бит"),
            new Question("Какой размер имеет тип long ? ", " 64 бит"),
            new Question("Какой размер имеет тип byte ? ", " 8 бит")
    );

    public static final Integer AMOUNT_BIGGER_THAN_SIZE_COLLECTION = 6;
    public static final Integer AMOUNT_LESS_THAN_ZERO = -2;
    public static final Integer AMOUNT_EQUALS_SIZE = 4;
}
