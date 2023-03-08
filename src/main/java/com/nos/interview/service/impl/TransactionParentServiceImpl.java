package com.nos.interview.service.impl;

import com.nos.interview.dto.QuizDto;
import com.nos.interview.entity.Quiz;
import com.nos.interview.enumeration.LargeCategory;
import com.nos.interview.repository.QuizRepository;
import com.nos.interview.service.QuizService;
import com.nos.interview.service.TransactionParentService;
import com.nos.interview.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionParentServiceImpl implements TransactionParentService {
    private final QuizRepository quizRepository;
    private final TransactionService transactionService;

    @Override
    @Transactional
    public void save(QuizDto quizDto) {
        transactionService.required(quizDto);

        /**
         * 아래와 같이 해줘야 전체 롤백이 안됨
         */
        try {
            transactionService.requiredNew(QuizDto.builder()
                    .largeCategory(LargeCategory.COMPUTER)
                    .question("requiredNewAnswer")
                    .answer("requiredNewAnswer")
                    .displayOrder(1)
                    .build());
        } catch (Exception e) {
            System.out.println("exception!!");
        }
    }

    @Override
    public void supportsSaveNoTransaction(QuizDto quizDto) {
        transactionService.supports(quizDto);
    }

    @Override
    @Transactional
    public void supportsSaveWithTransaction(QuizDto quizDto) {
        transactionService.supports(quizDto);
    }

    @Override
    @Transactional
    public void notSupportedWithTransaction(QuizDto quizDto) {
        quizRepository.save(Quiz.of(quizDto));

        try{
            transactionService.notSupported(QuizDto.builder()
                    .largeCategory(LargeCategory.COMPUTER)
                    .question("notSupported")
                    .answer("notSupported")
                    .displayOrder(1)
                    .build());
        } catch(Exception e){
            System.out.println("notSupported exception");
        }

        throw new NullPointerException();
    }

    @Transactional
    public void required(QuizDto quizDto){
        quizRepository.save(Quiz.of(quizDto));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiredNew(QuizDto quizDto){
        quizRepository.save(Quiz.of(quizDto));
        String str = null;
        str.getBytes();
    }
}
