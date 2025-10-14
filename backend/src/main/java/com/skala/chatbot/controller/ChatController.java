package com.skala.chatbot.controller;

import com.skala.chatbot.dto.ChatRequest;
import com.skala.chatbot.dto.ChatResponse;
import com.skala.chatbot.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        return chatService.getChatResponse(request);
    }
}
