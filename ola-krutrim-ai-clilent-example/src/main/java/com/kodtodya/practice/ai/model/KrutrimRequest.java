package com.kodtodya.practice.ai.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KrutrimRequest {
    private String model;
    private Message[] messages;
}
