package com.nos.interview.controller.rest;

import com.nos.interview.dto.PlayerDto;
import com.nos.interview.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping
    ResponseEntity<PlayerDto> save(@RequestBody PlayerDto requestDto){
        PlayerDto playerDto = playerService.save(requestDto);
        return ResponseEntity.ok(playerDto);
    }
}
