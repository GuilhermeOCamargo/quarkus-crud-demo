package br.com.gcamargo.model.dto;

public class PlayerDto {
    private long id;
    private String name;
    private int start;
    private int end;
    private double salary;
    private long team;

    public PlayerDto(long id, String name, int start, int end, double salary, long team) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.salary = salary;
        this.team = team;
    }

    public PlayerDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public long getTeam() {
        return team;
    }

    public void setTeam(long team) {
        this.team = team;
    }
}
