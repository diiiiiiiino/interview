package com.nos.interview.repository;

import com.nos.interview.entity.Quiz;
import com.nos.interview.enumeration.LargeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findAllByLargeCategory(LargeCategory largeCategory);
}
