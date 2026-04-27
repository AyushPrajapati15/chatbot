package com.chatbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatbot.model.MessageEntity;
import com.chatbot.repository.MessageRepository;

import java.time.LocalDateTime;

@Service
public class ChatbotService {

    @Autowired
    private MessageRepository repository;

    public String getReplyAndSave(String sender, String text) {
        String reply;
        String input = text.toLowerCase().trim();

        // Chatbot Logic
        if (input.equals("hi")) {
            reply = "Hello";
        } else if (input.equals("bye")) {
            reply = "Goodbye";
        } else {
            reply = "I only understand Hi or Bye!";
        }

        // Saving to MySQL
        MessageEntity message = new MessageEntity();
        message.setSender(sender);
        message.setIncomingMessage(text);
        message.setBotReply(reply);
        message.setCreatedAt(LocalDateTime.now());

        repository.save(message); // This line sends data to MySQL
        
        return reply;
    }
}
