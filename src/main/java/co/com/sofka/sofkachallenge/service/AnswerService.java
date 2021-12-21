package co.com.sofka.sofkachallenge.service;

import co.com.sofka.sofkachallenge.model.Answer;
import co.com.sofka.sofkachallenge.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnswerService {
    @Resource
    private AnswerRepository answerRepository;

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public List<Answer> findAll() {
        return (List<Answer>) answerRepository.findAll();
    }
}

