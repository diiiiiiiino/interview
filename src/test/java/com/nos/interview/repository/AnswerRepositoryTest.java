package com.nos.interview.repository;

import com.nos.interview.entity.Answer;
import com.nos.interview.entity.Question;
import com.nos.interview.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AnswerRepositoryTest extends BaseRepositoryTest {
    @Autowired
    AnswerRepository answerRepository;

    @Test
    void createAnswer() {
        Question question = Question.builder()
                .question("질문")
                .answer("답변")
                .displayOrder(1)
                .build();

        Student student = Student.builder()
                .email("eodyddnjs@naver.com")
                .name("노은석")
                .build();

        Answer answer = Answer.builder()
                .question(question)
                .student(student)
                .answer("답변")
                .build();

        answerRepository.save(answer);
    }
}
