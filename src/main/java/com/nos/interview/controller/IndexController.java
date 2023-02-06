package com.nos.interview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/index")
    public void index(String name, ModelAndView modelAndView){
        modelAndView.addObject("name", name);
    }
}
