package com.chatbot.repository;

import org.springframework.stereotype.Repository;

import com.chatbot.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    // JpaRepository provides basic CRUD operations, so no need to define methods here

}