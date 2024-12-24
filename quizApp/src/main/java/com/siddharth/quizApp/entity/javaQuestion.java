package com.siddharth.quizApp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class javaQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private String questionText;

    private String correctAnswer;


//    @ElementCollection
//    @CollectionTable(name = "questionOptions",joinColumns = @JoinColumn(name = "questionID"))
//    @Column(name = "optionText")
//    private List<String> options;

    //@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<javaOptions> options;


    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<javaOptions> getOptions() {
        return options;
    }

    public void setOptions(List<javaOptions> options) {
        this.options = options;
    }
}
