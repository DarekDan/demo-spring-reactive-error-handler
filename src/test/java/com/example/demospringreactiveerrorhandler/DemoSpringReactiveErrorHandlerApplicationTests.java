package com.example.demospringreactiveerrorhandler;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(OutputCaptureExtension.class)
@Slf4j
class DemoSpringReactiveErrorHandlerApplicationTests {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void contextLoads() {
        assertThat(webTestClient).isNotNull();
    }

    @Test
    void getGreetingMustReturnHelloWorld() {
        webTestClient.get().uri("/greeting/World").accept(MediaType.TEXT_PLAIN).exchange()
            .expectStatus().isOk().expectBody(String.class).isEqualTo("Hello, World!")
            .consumeWith(stringEntityExchangeResult -> log.info(stringEntityExchangeResult.getResponseBody()));
    }

    @Test
    void getGreetingMustFailWithoutName() {
        webTestClient.get().uri("/greeting/I").accept(MediaType.TEXT_PLAIN).exchange()
            .expectStatus().is4xxClientError().expectBody()
            .consumeWith(entityExchangeResult -> log.error(entityExchangeResult.toString()));
    }

    @Test
    void getGreetMustFail() {
        webTestClient.get().uri("/greet").accept(MediaType.APPLICATION_JSON).exchange()
            .expectStatus().is4xxClientError().expectBody()
            .consumeWith(entityExchangeResult -> log.error(entityExchangeResult.toString()));
    }
}
