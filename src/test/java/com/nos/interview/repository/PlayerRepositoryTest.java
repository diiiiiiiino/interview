package com.nos.interview.repository;

import com.nos.interview.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerRepositoryTest extends BaseRepositoryTest {
    @Autowired
    PlayerRepository playerRepository;

    @DisplayName("1. 학생 생성")
    @Test
    void createStudent(){
        Player player = Player.builder()
                .email("eodyddnjs@naver.com")
                .name("노은석")
                .build();
        playerRepository.save(player);
    }
}
