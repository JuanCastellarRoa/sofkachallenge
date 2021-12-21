package co.com.sofka.sofkachallenge.repository;

import co.com.sofka.sofkachallenge.model.Category;
import co.com.sofka.sofkachallenge.model.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository <Question, Integer> {
    List<Question> findByCategory(Category category);
}