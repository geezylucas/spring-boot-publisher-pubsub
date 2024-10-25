package com.geezylucas.springbootpublisherpubsub.publishers;

public abstract class PubSubPublisher<T> {

    protected abstract String topic();

    public abstract void publish(T message);
}