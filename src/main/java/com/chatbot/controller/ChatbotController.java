package com.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.chatbot.service.ChatbotService;
import com.chatbot.model.MessageEntity;

@RestController
@RequestMapping("/webhook")
public class ChatbotController {

    @Autowired
    private ChatbotService chatbotService;

    @PostMapping
    public Map<String, String> handleWebhook(@RequestBody MessageEntity message) {
        String reply = chatbotService.getReplyAndSave(
            message.getSender(), 
            message.getText()
        );

        return Map.of("reply", reply);
    }
}