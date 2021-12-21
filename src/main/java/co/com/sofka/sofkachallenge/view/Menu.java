package co.com.sofka.sofkachallenge.view;

import co.com.sofka.sofkachallenge.model.Category;
import co.com.sofka.sofkachallenge.model.Question;
import co.com.sofka.sofkachallenge.model.Answer;
import co.com.sofka.sofkachallenge.service.CategoryService;
import co.com.sofka.sofkachallenge.service.AnswerService;
import co.com.sofka.sofkachallenge.service.QuestionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class Menu implements CommandLineRunner {
    @Resource
    private CategoryService categoryService;

    @Resource
    private QuestionService questionService;

    @Resource
    private AnswerService answerService;

    @Override
    public void run(String... args) throws Exception {
        this.run();
    }


    public void run() {
        List<Category> categories = categoryService.findAll();
        for (Category category : categories) {
            System.out.println("Level: "+ category.getLevel() );
        }
        System.out.println(categories.size());

        List<Question> questions = questionService.findAll();
        for (Question question : questions) {
            System.out.println("Questions: " + question.getText());
        }
        System.out.println(questions.size());

        List<Answer> answers = answerService.findAll();
        for (Answer answer : answers) {
            System.out.println("Answers: " + answer.getText());
        }
        System.out.println(answers.size());

    }
}
