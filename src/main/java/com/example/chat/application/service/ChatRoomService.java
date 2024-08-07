package com.example.chat.application.service;

import org.redisson.api.RListReactive;
import org.redisson.api.RTopicReactive;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ChatRoomService implements WebSocketHandler {

    private final RTopicReactive topic;
    private final RListReactive<String> histories;

    public ChatRoomService(RedissonReactiveClient client) {

        this.topic = client.getTopic("room", StringCodec.INSTANCE);
        this.histories = client.getList("histories", StringCodec.INSTANCE);

    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {

        session.receive().map(WebSocketMessage::getPayloadAsText)
                .flatMap(message -> histories.add(message).then(topic.publish(message)))
                .doOnError(System.out::println).subscribe();

        Flux<WebSocketMessage> sendMessages = topic.getMessages(String.class).startWith(histories.iterator())

                .map(message -> session.textMessage(message)).doOnError(System.out::println);

        return session.send(sendMessages);

    }

}