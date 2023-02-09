package com.nos.interview.entity;

import com.nos.interview.dto.PlayerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 30)
    String email;

    @Column(nullable = false, length = 10)
    String name;

    public static Player of(PlayerDto playerDto){
        return Player.builder()
                .email(playerDto.getEmail())
                .name(playerDto.getName())
                .build();
    }
}
