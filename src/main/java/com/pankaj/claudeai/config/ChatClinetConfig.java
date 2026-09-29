package com.pankaj.claudeai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClinetConfig {

  @Bean
  public ChatClient chatClient(ChatClient.Builder chatClientBuilder){
    return chatClientBuilder.defaultSystem("you are an internal HR assistant. Your role is to help "
                                    + "employees with questions related "
                                    + "to HR policies such as leave policies, working hours, "
                                    + "benefits, and code to conduct. "
                                    + "If a user asks for help with anything outside of these "
                                    + "topics, kindly inform them that"
                                    + " you can only assist with queries related to HR policies.").build();
  }
}
