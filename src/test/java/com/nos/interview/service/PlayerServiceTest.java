package com.nos.interview.service;

import com.nos.interview.dto.PlayerDto;
import com.nos.interview.dto.QuizDto;
import com.nos.interview.entity.Player;
import com.nos.interview.entity.Quiz;
import com.nos.interview.enumeration.LargeCategory;
import com.nos.interview.repository.PlayerRepository;
import com.nos.interview.repository.QuizRepository;
import com.nos.interview.service.impl.PlayerServiceImpl;
import com.nos.interview.service.impl.QuizServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerServiceTest {
    PlayerRepository playerRepository;
    PlayerService playerService;

    PlayerServiceTest(){
        this.playerRepository = mock(PlayerRepository.class);
        this.playerService = new PlayerServiceImpl(playerRepository);
    }

    @DisplayName("1. 사용자 등록")
    @Test
    void save(){
        PlayerDto playerDto = PlayerDto.builder()
                .email("eodyddnjs@naver.com")
                .name("홍길동")
                .build();

        when(playerRepository.save(any(Player.class))).thenReturn(Player.builder()
                .id(1L)
                .email("eodyddnjs@naver.com")
                .name("홍길동")
                .build());

        PlayerDto playerDto1 = playerService.save(playerDto);

        Assertions.assertNotNull(playerDto1);
        Assertions.assertEquals(1, playerDto1.getId());
    }
}
