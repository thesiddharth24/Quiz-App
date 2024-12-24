package com.siddharth.quizApp.service;

import com.siddharth.quizApp.dto.javaQuestionDTO;
import com.siddharth.quizApp.entity.javaOptions;
import com.siddharth.quizApp.entity.javaQuestion;
import com.siddharth.quizApp.repo.javaQuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class javaService {

    @Autowired
    javaQuestionRepo javaQuestionRepo;

    public List<javaQuestionDTO> getAllQuestions(){
//        List<javaQuestion> allQuestions = javaQuestionRepo.findAll();
//        return allQuestions;
        List<javaQuestion> allQuestions = javaQuestionRepo.findAll();
        return allQuestions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private javaQuestionDTO convertToDTO(javaQuestion question) {
        javaQuestionDTO dto = new javaQuestionDTO();
        dto.setQuestion(question.getQuestionText());
        dto.setAnswer(question.getCorrectAnswer());
        dto.setOptions(question.getOptions().stream()
                .map(javaOptions::getOptionText)
                .toArray(String[]::new));
        return dto;
    }

    public javaQuestion saveQuestion(javaQuestion question){
        javaQuestion save = javaQuestionRepo.save(question);

        return save;
    }

}
