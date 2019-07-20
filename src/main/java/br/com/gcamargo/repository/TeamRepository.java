package br.com.gcamargo.repository;

import br.com.gcamargo.model.Team;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface TeamRepository extends PanacheRepository<Team> {
}
