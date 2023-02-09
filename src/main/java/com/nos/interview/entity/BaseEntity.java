package com.nos.interview.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

public abstract class BaseEntity {
    @CreationTimestamp
    LocalDateTime createDate;
    @UpdateTimestamp
    LocalDateTime updateDate;
}
