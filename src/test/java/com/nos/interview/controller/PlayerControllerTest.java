package com.nos.interview.controller;

import com.nos.interview.dto.PlayerDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PlayerControllerTest extends BaseControllerTest {
    @DisplayName("1. 사용자 등록")
    @Test
    void save() throws Exception {
        mockMvc.perform(request(HttpMethod.POST,"/player", PlayerDto.builder()
                        .email("esnoh@softnet.co.kr")
                        .name("홍길동")
                        .build()))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
