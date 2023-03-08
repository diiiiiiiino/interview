package com.nos.interview.service;

import com.nos.interview.dto.QuizDto;
import com.nos.interview.entity.Quiz;
import com.nos.interview.enumeration.LargeCategory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TransactionService {
    void required(QuizDto quizDto);
    void requiredNew(QuizDto quizDto);
    void supports(QuizDto quizDto);
    void notSupported(QuizDto quizDto);
}
