package com.vn32.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@MappedSuperclass //means it will be added into the child class where ever it's been used a inheritance and create database
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    //update and create date will be managed by localdate but what about which user creating and updatading for this logic in audit package
    @CreatedDate //means whenever you see this column update this with created date
    @Column(updatable = false) //do not populate this column when there is a update query
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(insertable = false)//do not populate this column when insert query used
    private LocalDateTime updatedAt;

    @LastModifiedBy //spring data jpa will take care of updated by,date and created by and date
    @Column(insertable = false)
    private String updatedBy;
}

/*
Annotation purpose:
@EntityListeners is a JPA annotation used to hook into entity lifecycle events (like creation, update, deletion). It allows you to specify a listener class that reacts when those events occur.

AuditingEntityListener:
This is a special listener provided by Spring Data JPA. When you attach it to your entity, it automatically populates auditing fields such as:

@CreatedDate → sets the timestamp when the entity is first persisted.

@LastModifiedDate → updates the timestamp whenever the entity is updated.

@CreatedBy → stores the user who created the entity.

@LastModifiedBy → stores the user who last modified the entity.

How it works:
When you save or update an entity, the AuditingEntityListener intercepts those lifecycle events and fills in the annotated fields without you having to manually set them.
 */
