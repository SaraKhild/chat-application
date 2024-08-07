package com.example.chat.application.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;

import com.example.chat.application.service.ChatRoomService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebSocketConfig {

    private final ChatRoomService chatRoomService;

     @Bean
    public HandlerMapping handlerMapping() {

        Map<String, WebSocketHandler> handlerMap = Map.of("/chat", chatRoomService);
        return new SimpleUrlHandlerMapping(handlerMap,1);
        
    }
    
}