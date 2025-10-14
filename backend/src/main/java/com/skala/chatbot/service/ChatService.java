package com.skala.chatbot.service;

import com.skala.chatbot.dto.ChatRequest;
import com.skala.chatbot.dto.ChatResponse;
import com.theokanning.openai.service.OpenAiService;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class ChatService {

    private final OpenAiService openAiService;

    public ChatService() {
        String apiKey = System.getenv("OPENAI_API_KEY");
        if (apiKey == null) {
            throw new IllegalStateException("❌ OPENAI_API_KEY 환경 변수가 설정되지 않았습니다.");
        }
        this.openAiService = new OpenAiService(apiKey, Duration.ofSeconds(60));
    }

    // ✅ ChatRequest를 입력받고 ChatResponse를 반환
    public ChatResponse getChatResponse(ChatRequest request) {
        String userMessage = request.getMessage();

        ChatMessage user = new ChatMessage("user", userMessage);

        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(List.of(user))
                .build();

        String answer = openAiService.createChatCompletion(completionRequest)
                .getChoices()
                .get(0)
                .getMessage()
                .getContent();

        return new ChatResponse(answer);
    }
}
