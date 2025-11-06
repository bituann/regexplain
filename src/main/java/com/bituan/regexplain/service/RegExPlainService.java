package com.bituan.regexplain.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class RegExPlainService {
    private ChatClient chatClient;

    RegExPlainService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @Tool(name = "regexplain", description = "An agent that explains what type of string a regex pattern matches")
    public String generateResponse(String regex) {
        return chatClient
                .prompt("Give me a simple explanation of the type of string matched by this regex pattern: %s. No validating statements from you. Just straight to the point".formatted(regex))
                .call()
                .content();
    }
}
