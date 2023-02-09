package com.nos.interview.repository;

import com.nos.interview.entity.Answer;
import com.nos.interview.entity.Quiz;
import com.nos.interview.entity.Player;
import com.nos.interview.enumeration.LargeCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AnswerRepositoryTest extends BaseRepositoryTest {
    @Autowired
    AnswerRepository answerRepository;

    @Test
    void createAnswer() {
        Quiz quiz = Quiz.builder()
                .question("질문")
                .answer("답변")
                .largeCategory(LargeCategory.COMPUTER)
                .displayOrder(1)
                .build();

        Player player = Player.builder()
                .email("eodyddnjs@naver.com")
                .name("노은석")
                .build();

        Answer answer = Answer.builder()
                .quiz(quiz)
                .player(player)
                .answer("답변")
                .build();

        answerRepository.save(answer);
    }
}
