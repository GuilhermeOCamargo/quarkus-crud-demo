package br.com.gcamargo.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@RegisterForReflection
public class Team extends PanacheEntity {
    static final int SIZE = 20;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Player> players = new ArrayList<>();


    @Deprecated
    Team() {
    }

    private Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Player player) {
        Objects.requireNonNull(player, "player is required");

        if (players.size() == SIZE) {
            throw new IllegalArgumentException("The team is full");
        }
        this.players.add(player);
    }
    public void remove(Player player){
        Objects.requireNonNull(player, "player is required");
        if(players.isEmpty()){
            throw new IllegalArgumentException("The team is empty");
        }
        this.players.remove(player);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public static Team of(String name) {
        return new Team(Objects.requireNonNull(name, "name is required"));
    }
}
