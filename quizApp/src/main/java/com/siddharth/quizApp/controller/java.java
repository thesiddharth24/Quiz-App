package com.siddharth.quizApp.controller;


import com.siddharth.quizApp.dto.javaQuestionDTO;
import com.siddharth.quizApp.entity.javaQuestion;
import com.siddharth.quizApp.service.javaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/java")
public class java {

    @Autowired
    javaService javaService;

    @GetMapping("/questions")
    public List<javaQuestionDTO> getQuestions(){
        List<javaQuestionDTO> questions = javaService.getAllQuestions();
        return questions;
    }

    @PostMapping(value = "/save" , consumes = "application/json" , produces = "application/josn")
    public javaQuestion saveQuestion(@RequestBody javaQuestion question){
        return javaService.saveQuestion(question);
    }


}
