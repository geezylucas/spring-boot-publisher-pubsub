package com.geezylucas.springbootpublisherpubsub.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserMessage {

    private String body;
    private String username;
    private int random;
    private LocalDateTime createdAt;
}
