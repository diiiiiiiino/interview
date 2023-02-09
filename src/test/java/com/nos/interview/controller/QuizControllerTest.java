package com.nos.interview.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nos.interview.dto.QuizDto;
import com.nos.interview.enumeration.LargeCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class QuizControllerTest extends BaseControllerTest {
    String baseUrl = "/quiz";

    @DisplayName("1. 퀴즈 등록")
    @Test
    void save() throws Exception {
        mockMvc.perform(request(HttpMethod.POST, baseUrl, QuizDto.builder()
                .largeCategory(LargeCategory.COMPUTER)
                .question("컴퓨터 구조 구성요소")
                .displayOrder(1)
                .build()))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("2. 퀴즈 조회 by 대분류")
    @Test
    void findAllByLargeCategory() throws Exception {
        mockMvc.perform(get(baseUrl, HttpMethod.GET)
                .param("largeCategory", LargeCategory.COMPUTER.name()))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
