package com.nos.interview.service;

import com.nos.interview.dto.QuizDto;

public interface TransactionParentService {
    void save(QuizDto quizDto);
    void supportsSaveNoTransaction(QuizDto quizDto);
    void supportsSaveWithTransaction(QuizDto quizDto);
    void notSupportedWithTransaction(QuizDto quizDto);
}
