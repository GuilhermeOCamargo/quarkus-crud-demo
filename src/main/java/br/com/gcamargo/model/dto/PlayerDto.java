package br.com.gcamargo.model.dto;

import java.time.Year;
import java.util.Currency;

public class PlayerDto {
    private long id;
    private String name;
    private Year start;
    private Year end;
    private double salary;
    private Currency currency;
    private long team;

    public long getId() {
        return id;
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

    public Currency getCurrency() {
        return currency;
    }

    public long getTeam() {
        return team;
    }
}
