package com.siddharth.quizApp.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class javaOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;

    private String optionText;

//    @ManyToOne
//    @JoinColumn(name= "question_id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private javaQuestion question;




    //generate getter setter

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public javaQuestion getQuestion() {
        return question;
    }

    public void setQuestion(javaQuestion question) {
        this.question = question;
    }
}
