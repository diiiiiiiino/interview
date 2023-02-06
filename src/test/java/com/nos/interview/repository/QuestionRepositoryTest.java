package com.nos.interview.repository;

import com.nos.interview.entity.Question;
import com.nos.interview.enumeration.LargeCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionRepositoryTest extends BaseRepositoryTest {
    @Autowired
    QuestionRepository questionRepository;

    @Test
    void createQuestion() {
        Question question = Question.builder()
                .largeCategory(LargeCategory.COMPUTER)
                .question("질문")
                .answer("답변")
                .displayOrder(1)
                .build();

        questionRepository.save(question);
    }
}
