package com.nos.interview.repository;

import com.nos.interview.entity.Quiz;
import com.nos.interview.enumeration.LargeCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuizRepositoryTest extends BaseRepositoryTest {
    @Autowired
    QuizRepository quizRepository;

    @DisplayName("1. 퀴즈 등록")
    @Test
    void createQuestion() {
        Quiz quiz = Quiz.builder()
                .largeCategory(LargeCategory.COMPUTER)
                .question("질문")
                .answer("답변")
                .displayOrder(1)
                .build();

        quizRepository.save(quiz);
    }

    @DisplayName("2. 퀴즈 등록")
    @Test
    void findAllByLargeCategory(){
        Quiz quiz = Quiz.builder()
                .largeCategory(LargeCategory.COMPUTER)
                .question("질문")
                .answer("답변")
                .displayOrder(1)
                .build();

        Quiz quiz2 = Quiz.builder()
                .largeCategory(LargeCategory.JAVA)
                .question("질문2")
                .answer("답변2")
                .displayOrder(12)
                .build();

        quizRepository.saveAll(List.of(quiz, quiz2));

        List<Quiz> quizzes = quizRepository.findAllByLargeCategory(LargeCategory.COMPUTER);

        Assertions.assertEquals(1, quizzes.size());
    }
}
