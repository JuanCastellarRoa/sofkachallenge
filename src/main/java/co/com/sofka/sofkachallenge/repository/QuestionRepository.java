package co.com.sofka.sofkachallenge.repository;

import co.com.sofka.sofkachallenge.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository <Question, Integer> {

}