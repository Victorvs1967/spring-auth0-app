package com.vvs.springauth0app.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vvs.springauth0app.model.Message;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
public class ApiController {
  
  @GetMapping(value = "/public")
  public Mono<Message> publicEndpoint() {
    return Mono.just(Message.builder()
      .message("All good. You DO NOT need to be authenticated to call /api/public.")
      .build());
  }

  @GetMapping(value = "/private")
  public Mono<Message> privateEndpoint() {
    return Mono.just(Message.builder()
      .message("All good. You can see this because you are Authenticated.")
      .build());
  }

  @GetMapping(value = "/private-scoped")
  public Mono<Message> privateScopedEndpoint() {
    return Mono.just(Message.builder()
      .message("All good. You can see this because you are Authenticated with a token granted the 'read:messages' scope.")
      .build());
  }
}
