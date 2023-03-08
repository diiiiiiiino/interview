package com.nos.interview.service.impl;

import com.nos.interview.dto.QuizDto;
import com.nos.interview.entity.Quiz;
import com.nos.interview.enumeration.LargeCategory;
import com.nos.interview.repository.QuizRepository;
import com.nos.interview.service.QuizService;
import com.nos.interview.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final QuizRepository quizRepository;

    @Transactional
    public void required(QuizDto quizDto){
        quizRepository.save(Quiz.of(quizDto));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiredNew(QuizDto quizDto){
        quizRepository.save(Quiz.of(quizDto));
        throw new NullPointerException();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void supports(QuizDto quizDto){
        quizRepository.save(Quiz.of(quizDto));
        throw new NullPointerException();
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void notSupported(QuizDto quizDto) {
        quizRepository.save(Quiz.of(quizDto));
        throw new NullPointerException();
    }
}
