package co.com.sofka.sofkachallenge.repository;

import co.com.sofka.sofkachallenge.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository <Player, Integer> {
    List<Player> findByName(String name);

}