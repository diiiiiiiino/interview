package com.nos.interview.service;

import com.nos.interview.dto.QuizDto;
import com.nos.interview.entity.Quiz;
import com.nos.interview.enumeration.LargeCategory;
import com.nos.interview.repository.QuizRepository;
import com.nos.interview.service.impl.QuizServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuizServiceTest {
    QuizRepository quizRepository;
    QuizService quizService;

    QuizServiceTest(){
        this.quizRepository = mock(QuizRepository.class);
        this.quizService = new QuizServiceImpl(quizRepository);
    }

    @DisplayName("1. 퀴즈 등록")
    @Test
    void save(){
        QuizDto quizDto = QuizDto.builder()
                .largeCategory(LargeCategory.COMPUTER)
                .question("질문")
                .answer("답변")
                .displayOrder(1)
                .build();

        when(quizRepository.save(any(Quiz.class))).thenReturn(Quiz.builder()
                .id(1L)
                .largeCategory(LargeCategory.COMPUTER)
                .question("질문")
                .answer("답변")
                .displayOrder(1)
                .build());

        QuizDto quizDto1 = quizService.save(quizDto);

        Assertions.assertNotNull(quizDto1);
        Assertions.assertEquals(1, quizDto1.getId());
    }

    @DisplayName("2. 퀴즈 조회 by 대분류")
    @Test
    void findAllByLargeCategory(){
        List<Quiz> quizzes = List.of(
                Quiz.builder().id(1L).largeCategory(LargeCategory.COMPUTER).question("질문").answer("답변").displayOrder(1).build(),
                Quiz.builder().id(2L).largeCategory(LargeCategory.COMPUTER).question("질문").answer("답변").displayOrder(1).build());

        when(quizRepository.findAllByLargeCategory(any(LargeCategory.class))).thenReturn(quizzes);

        List<QuizDto> quizDtoList = quizService.findByLargeCategory(LargeCategory.COMPUTER);

        Assertions.assertEquals(2, quizDtoList.size());
    }
}
