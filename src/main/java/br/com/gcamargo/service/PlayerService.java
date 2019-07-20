package br.com.gcamargo.service;

import br.com.gcamargo.model.Player;
import br.com.gcamargo.repository.PlayerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PlayerService {
    @Inject
    private PlayerRepository playerRepository;

    public void save(Player player){
        playerRepository.persist(player);
    }
    public Player findById(Long id){
        return playerRepository.findById(id);
    }
}
