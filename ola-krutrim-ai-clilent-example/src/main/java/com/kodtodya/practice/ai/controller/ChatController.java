package com.kodtodya.practice.ai.controller;

import com.kodtodya.practice.ai.model.KrutrimRequest;
import com.kodtodya.practice.ai.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/ai")
public class ChatController {

    @Value("${application.ai.ola-krutim.base-url}")
    private String baseUrl;

    @Value("${application.ai.ola-krutim.model}")
    private String model;

    @Value("${application.ai.ola-krutim.api-key}")
    private String apiKey;

    @PostMapping("/ola-krutrim/generateStream")
	public Mono<String> generateStream(@RequestBody String message) {

        KrutrimRequest request = new KrutrimRequest();
        request.setModel(model);
        Message msg = new Message();
        msg.setContent(message);
        request.setMessages(new Message[]{msg});

        return WebClient.create(baseUrl)
                .post()
                .headers(header -> {
                    header.setBearerAuth(apiKey);
                    header.setContentType(MediaType.APPLICATION_JSON);
                })
                .bodyValue(request)
                .retrieve()
                .bodyToMono(String.class);
    }
}