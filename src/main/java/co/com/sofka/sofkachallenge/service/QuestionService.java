package co.com.sofka.sofkachallenge.service;

import co.com.sofka.sofkachallenge.model.Question;
import co.com.sofka.sofkachallenge.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionService {
    @Resource
    private QuestionRepository questionRepository;

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> findAll() {
        return (List<Question>) questionRepository.findAll();
    }

}
