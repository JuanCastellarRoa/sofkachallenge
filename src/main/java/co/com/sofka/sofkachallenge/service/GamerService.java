package co.com.sofka.sofkachallenge.service;

import co.com.sofka.sofkachallenge.model.Gamer;
import co.com.sofka.sofkachallenge.repository.GamerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GamerService {
    @Resource
    private GamerRepository gamerRepository;

    public Gamer createGamer(Gamer gamer) {
        return gamerRepository.save(gamer);
    }

    public List<Gamer> findAll() {
        return (List<Gamer>) gamerRepository.findAll();
    }

}
