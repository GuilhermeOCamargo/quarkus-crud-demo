package br.com.gcamargo.service;

import br.com.gcamargo.converter.PlayerConverter;
import br.com.gcamargo.model.Player;
import br.com.gcamargo.model.Team;
import br.com.gcamargo.model.dto.PlayerDto;
import br.com.gcamargo.repository.PlayerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PlayerService {
    @Inject
    private PlayerRepository playerRepository;
    @Inject
    private TeamService teamService;

    @Transactional
    private void save(Player player){
        playerRepository.persist(player);
    }

    public Player findById(Long id){
        return playerRepository.findById(id);
    }

    public List<Player> findAll(){
        return playerRepository.listAll();
    }

    @Transactional
    public Player addPlayer(PlayerDto dto){
        Team team = teamService.findById(dto.getTeam());
        Player player = PlayerConverter.fromDto(dto);
        save(player);
        team.add(player);
        teamService.save(team);
        return player;
    }
}
