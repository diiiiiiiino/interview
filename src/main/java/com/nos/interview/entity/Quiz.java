package com.nos.interview.entity;

import com.nos.interview.enumeration.LargeCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, length = 20)
    LargeCategory largeCategory;

    @Column(nullable = false, length = 500)
    String question;

    @Column(nullable = false, length = 1000)
    String answer;

    Integer displayOrder;
}
