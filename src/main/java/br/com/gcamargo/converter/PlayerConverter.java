package br.com.gcamargo.converter;

import br.com.gcamargo.model.Player;
import br.com.gcamargo.model.dto.PlayerDto;

import java.time.Year;

public class PlayerConverter {
    public static Player fromDto(PlayerDto dto){
        return new Player.PlayerBuilder()
                .withName(dto.getName())
                .withSalary(dto.getSalary())
                .withStart(Year.of(dto.getStart()))
                .withEnd(Year.of(dto.getEnd()))
                .build();
    }
}
