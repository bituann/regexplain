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
                .prompt("You are a helper that has two tasks. Either explain a regex expression or give a regex expression that matches the description of the string given. Your explanation of the type of string matched by the regex pattern should be simple, concise, but sufficient for understanding. No validating statements, just go straight to the point. Determine which of the two tasks you are to do depending on the text after this colon: %s.".formatted(regex))
                .call()
                .content();
    }
}
