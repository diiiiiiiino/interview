package com.nos.interview.service;

import com.nos.interview.dto.QuizDto;
import com.nos.interview.enumeration.LargeCategory;

import java.util.List;

public interface QuizService {
    QuizDto save(QuizDto quizDto);
    List<QuizDto> findByLargeCategory(LargeCategory category);
}
