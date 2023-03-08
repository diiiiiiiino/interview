package com.nos.interview.controller.rest;

import com.nos.interview.dto.QuizDto;
import com.nos.interview.enumeration.LargeCategory;
import com.nos.interview.service.QuizService;
import com.nos.interview.service.TransactionParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionParentService transactionParentService;

    @PostMapping
    ResponseEntity<QuizDto> save(@RequestBody QuizDto requestDto) {
        transactionParentService.save(requestDto);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/supports")
    ResponseEntity<QuizDto> supportsNoTransaction(@RequestBody QuizDto requestDto) {
        transactionParentService.supportsSaveNoTransaction(requestDto);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/supports-transaction")
    ResponseEntity<QuizDto> supportsWithTransaction(@RequestBody QuizDto requestDto) {
        transactionParentService.supportsSaveWithTransaction(requestDto);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/not-supported-transaction")
    ResponseEntity<QuizDto> notSupportedWithTransaction(@RequestBody QuizDto requestDto) {
        transactionParentService.notSupportedWithTransaction(requestDto);
        return ResponseEntity.ok(null);
    }
}
