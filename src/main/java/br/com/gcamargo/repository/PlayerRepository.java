package br.com.gcamargo.repository;

import br.com.gcamargo.model.Player;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlayerRepository implements PanacheRepository<Player> {
}
