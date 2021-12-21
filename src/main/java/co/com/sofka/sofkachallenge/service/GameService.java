package co.com.sofka.sofkachallenge.service;

import co.com.sofka.sofkachallenge.model.Game;
import co.com.sofka.sofkachallenge.repository.GameRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GameService {
    @Resource
    private GameRepository gameRepository;

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public List<Game> findAll() {
        return (List<Game>) gameRepository.findAll();
    }

}
