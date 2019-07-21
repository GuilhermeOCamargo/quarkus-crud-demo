package br.com.gcamargo.service;

import br.com.gcamargo.model.Team;
import br.com.gcamargo.repository.TeamRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class TeamService {
    @Inject
    private TeamRepository teamRepository;

    @Transactional
    public void save(Team team){
        teamRepository.persist(team);
    }

    public Team findById(Long id){
        Team team = teamRepository.findById(id);
        if(team == null){
            throw new NotFoundException("Team does not exists");
        }
        return team;
    }
    public List<Team> findAll(){
        return teamRepository.listAll();
    }
}