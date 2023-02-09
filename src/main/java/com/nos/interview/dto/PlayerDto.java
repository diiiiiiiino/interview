package com.nos.interview.dto;

import com.nos.interview.entity.Player;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerDto {
    Long id;
    String email;
    String name;

    public static PlayerDto of(Player player){
        return PlayerDto.builder()
                .id(player.getId())
                .email(player.getEmail())
                .name(player.getName())
                .build();
    }
}
