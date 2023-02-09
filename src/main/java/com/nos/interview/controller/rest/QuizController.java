package com.nos.interview.controller.rest;

import com.nos.interview.dto.QuizDto;
import com.nos.interview.enumeration.LargeCategory;
import com.nos.interview.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @PostMapping
    ResponseEntity<QuizDto> save(@RequestBody QuizDto requestDto){
        QuizDto quizDto = quizService.save(requestDto);
        return ResponseEntity.ok(quizDto);
    }

    @GetMapping
    ResponseEntity<List<QuizDto>> findAllByCategory(@RequestParam LargeCategory largeCategory){
        return ResponseEntity.ok(quizService.findByLargeCategory(largeCategory));
    }
}
