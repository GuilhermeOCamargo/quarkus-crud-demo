package br.com.gcamargo.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.time.Year;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;

@Entity
public class Player extends PanacheEntity {
    static final Year SOCCER_BORN = Year.of(1863);

    private String name;
    private Year start;
    private Year end;
    private double salary;
    private int goal = 0;

    public Player(String name, Year start, Year end, double salary) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.salary = salary;
        this.goal = goal;
    }
    @Deprecated
    public Player() {
    }

    public String getName() {
        return name;
    }

    public Year getStart() {
        return start;
    }

    public Year getEnd() {
        return end;
    }

    public double getSalary() {
        return salary;
    }

    public int getGoal() {
        return goal;
    }

    public void goal(){
        goal++;
    }

    public void setEnd(Year end) {
        if (end != null && end.isBefore(start)) {
            throw new IllegalArgumentException("the last year of a player must be equal or higher than the start.");
        }
        this.end = end;
    }

    public static class PlayerBuilder {
        private String name;
        private Year start;
        private Year end;
        private double salary;

        public PlayerBuilder withName(String name) {
            this.name = Objects.requireNonNull(name, "name is required");
            return this;
        }

        public PlayerBuilder withStart(Year start) {
            Objects.requireNonNull(start, "start is required");
            if (Year.now().isBefore(start)) {
                throw new IllegalArgumentException("you cannot start in the future");
            }
            if (SOCCER_BORN.isAfter(start)) {
                throw new IllegalArgumentException("Soccer was not born on this time");
            }
            this.start = start;
            return this;
        }

        public PlayerBuilder withEnd(Year end) {
            Objects.requireNonNull(end, "end is required");

            if (start != null && start.isAfter(end)) {
                throw new IllegalArgumentException("the last year of a player must be equal or higher than the start.");
            }

            if (SOCCER_BORN.isAfter(end)) {
                throw new IllegalArgumentException("Soccer was not born on this time");
            }
            this.end = end;
            return this;
        }

        public PlayerBuilder withSalary(double salary) {
            Objects.requireNonNull(salary, "salary is required");
            if (salary <= 0) {
                throw new IllegalArgumentException("A player needs to earn money to play; otherwise, it is illegal.");
            }
            this.salary = salary;
            return this;
        }

        public Player build() {
            Objects.requireNonNull(name, "name is required");
            Objects.requireNonNull(start, "start is required");
            Objects.requireNonNull(salary, "salary is required");

            return new Player(name, start, end, salary);
        }


    }
}
