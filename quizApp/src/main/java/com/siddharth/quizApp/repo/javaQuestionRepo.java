package com.siddharth.quizApp.repo;

import com.siddharth.quizApp.entity.javaQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface javaQuestionRepo extends JpaRepository<javaQuestion,Long> {
}
