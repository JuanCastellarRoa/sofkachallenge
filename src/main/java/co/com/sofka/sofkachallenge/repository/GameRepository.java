package co.com.sofka.sofkachallenge.repository;

import co.com.sofka.sofkachallenge.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository <Game, Integer> {

}