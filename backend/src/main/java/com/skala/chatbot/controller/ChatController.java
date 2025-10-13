package main.java.com.skala.chatbot.controller;

import com.skala.chatbot.dto.ChatRequest;
import com.skala.chatbot.dto.ChatResponse;
import com.skala.chatbot.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ChatController {

    private final ChatService chatService;
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        return chatService.getReply(request);
    }
}
