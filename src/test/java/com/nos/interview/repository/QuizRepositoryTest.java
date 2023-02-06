package com.nos.interview.repository;

import com.nos.interview.entity.Quiz;
import com.nos.interview.enumeration.LargeCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class QuizRepositoryTest extends BaseRepositoryTest {
    @Autowired
    QuizRepository quizRepository;

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
}
