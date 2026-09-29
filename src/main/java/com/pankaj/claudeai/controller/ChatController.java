package com.pankaj.claudeai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {


  private final ChatClient chatClient;

  public ChatController(ChatClient.Builder chatClientBuilder){
    this.chatClient = chatClientBuilder.build();
  }

  @GetMapping("/chat")
  public String chat(@RequestParam String message){
    return chatClient.prompt().
                     system("you are an internal HR assistant. Your role is to help employees with questions related "
                            + "to HR policies such as leave policies, working hours, benefits, and code to conduct. "
                            + "If a user asks for help with anything outside of these topics, kindly inform them that"
                            + " you can only assist with queries related to HR policies.").
            user(message).call().content();

  }
}


