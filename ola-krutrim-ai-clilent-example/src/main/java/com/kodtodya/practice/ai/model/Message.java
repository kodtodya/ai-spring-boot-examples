package com.kodtodya.practice.ai.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private String role = "system";
    private String content;
}
