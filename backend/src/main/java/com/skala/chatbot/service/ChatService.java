package main.java.com.skala.chatbot.service;

import com.skala.chatbot.dto.ChatRequest;
import com.skala.chatbot.dto.ChatResponse;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.chat.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChatService {

    @Value("${openai.api.key}")
    private String openaiApiKey;

    public ChatResponse getReply(ChatRequest request) {
        OpenAiService service = new OpenAiService(openaiApiKey);

        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(List.of(new ChatMessage("user", request.getMessage())))
                .maxTokens(150)
                .build();

        ChatCompletionResult result = service.createChatCompletion(completionRequest);
        String reply = result.getChoices().get(0).getMessage().getContent();

        return new ChatResponse(reply);
    }
}
