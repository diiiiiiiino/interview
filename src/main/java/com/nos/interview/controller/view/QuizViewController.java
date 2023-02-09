package com.nos.interview.controller.view;

import com.nos.interview.dto.QuizDto;
import com.nos.interview.enumeration.LargeCategory;
import com.nos.interview.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/view/quiz")
@RequiredArgsConstructor
public class QuizViewController {
    private final QuizService quizService;

    @GetMapping
    public void quiz(@RequestParam LargeCategory largeCategory, Model modelAndView){
        List<QuizDto> quizDtos = quizService.findByLargeCategory(largeCategory);

        modelAndView.addAttribute("quizzes", quizDtos);
    }
}
