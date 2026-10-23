package com.spring.ai.firstproject.service;

import com.spring.ai.firstproject.tools.SimpleDateTimeTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private ChatClient chatClient;

    public ChatService(ChatClient chatClient){
        this.chatClient = chatClient;
    }
//   chat method get response from LLM model
//   chatClient use for calling LLM model
//   tool description chatbot for tool calling
    public String chat(String q){
        System.out.println("Getting Date");
        return chatClient
                .prompt()
                .tools(new SimpleDateTimeTool())
                .user(q)
                .call()
                .content();
    }
}
