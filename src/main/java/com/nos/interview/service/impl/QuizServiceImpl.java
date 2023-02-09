package com.nos.interview.service.impl;

import com.nos.interview.dto.QuizDto;
import com.nos.interview.entity.Quiz;
import com.nos.interview.enumeration.LargeCategory;
import com.nos.interview.repository.QuizRepository;
import com.nos.interview.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;

    @Override
    @Transactional
    public QuizDto save(QuizDto quizDto) {
        Quiz quiz = quizRepository.save(Quiz.of(quizDto));
        return QuizDto.of(quiz);
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuizDto> findByLargeCategory(LargeCategory category) {
        return quizRepository.findAllByLargeCategory(category).stream()
                .map(QuizDto::of)
                .collect(Collectors.toList());
    }
}
