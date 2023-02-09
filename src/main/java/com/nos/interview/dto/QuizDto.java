package com.nos.interview.dto;

import com.nos.interview.entity.Quiz;
import com.nos.interview.enumeration.LargeCategory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuizDto {
    Long id;
    LargeCategory largeCategory;
    String question;
    String answer;
    Integer displayOrder;

    public static QuizDto of(Quiz quiz){
        return QuizDto.builder()
                .id(quiz.getId())
                .largeCategory(quiz.getLargeCategory())
                .question(quiz.getQuestion())
                .answer(quiz.getAnswer())
                .displayOrder(quiz.getDisplayOrder())
                .build();
    }
}
