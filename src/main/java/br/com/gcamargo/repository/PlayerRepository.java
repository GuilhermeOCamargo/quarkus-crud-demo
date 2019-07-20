package br.com.gcamargo.repository;

import br.com.gcamargo.model.Player;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface PlayerRepository extends PanacheRepository<Player> {
}
