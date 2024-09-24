package com.geezylucas.springbootpublisherpubsub.publishers;

import com.geezylucas.springbootpublisherpubsub.model.UserMessage;
import com.google.cloud.spring.pubsub.core.publisher.PubSubPublisherTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class HelloPubSubPublisher extends PubSubPublisher<UserMessage> {

    private final PubSubPublisherTemplate pubSubPublisherTemplate;

    @Override
    protected String topic() {
        return "myRunTopic";
    }

    @Override
    public void publish(UserMessage message) {
        log.info("Publishing to topic {}, message: {}", topic(), message);
        pubSubPublisherTemplate.publish(topic(), message);
    }
}