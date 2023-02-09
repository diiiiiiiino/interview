package com.nos.interview.service.impl;

import com.nos.interview.dto.PlayerDto;
import com.nos.interview.entity.Player;
import com.nos.interview.repository.PlayerRepository;
import com.nos.interview.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    @Override
    public PlayerDto save(PlayerDto playerDto) {
        Player player = playerRepository.save(Player.of(playerDto));
        return PlayerDto.of(player);
    }
}
