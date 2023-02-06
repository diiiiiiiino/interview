package com.nos.interview.repository;

import com.nos.interview.entity.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentRepositoryTest extends BaseRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @DisplayName("1. 학생 생성")
    @Test
    void createStudent(){
        Student student = Student.builder()
                .email("eodyddnjs@naver.com")
                .name("노은석")
                .build();
        studentRepository.save(student);
    }
}
