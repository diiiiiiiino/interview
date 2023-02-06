package com.nos.interview.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {

    @GetMapping("/hello")
    public String hello(String name){
        return "hello " + name;
    }
}
