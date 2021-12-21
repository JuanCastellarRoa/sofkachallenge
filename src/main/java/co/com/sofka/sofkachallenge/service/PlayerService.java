package co.com.sofka.sofkachallenge.service;

import co.com.sofka.sofkachallenge.model.Player;
import co.com.sofka.sofkachallenge.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlayerService {
    @Resource
    private PlayerRepository playerRepository;

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> findAll() {
        return (List<Player>) playerRepository.findAll();
    }

    public Player findByName(String name) {
        List<Player> players = playerRepository.findByName(name);
        return !players.isEmpty() ? players.get(0) : null;
    }

}
