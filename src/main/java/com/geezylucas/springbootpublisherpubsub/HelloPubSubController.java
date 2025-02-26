package com.geezylucas.springbootpublisherpubsub;

import com.geezylucas.springbootpublisherpubsub.dto.UserMessageDTO;
import com.geezylucas.springbootpublisherpubsub.model.UserMessage;
import com.geezylucas.springbootpublisherpubsub.publishers.HelloPubSubPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class HelloPubSubController {

    private final HelloPubSubPublisher publisher;

    @PostMapping("/publish")
    public Mono<String> publish(@RequestBody UserMessageDTO userMessageDTO) {
        log.info("Received a POST at /v1/publish with message: {}", userMessageDTO);

        // create instance of Random class
        SecureRandom rand = new SecureRandom();
        UserMessage userMessage = new UserMessage(userMessageDTO.body(), userMessageDTO.username(), rand.nextInt(3), LocalDateTime.now());

        publisher.publish(userMessage);

        return Mono.just("Message published!");
    }
}