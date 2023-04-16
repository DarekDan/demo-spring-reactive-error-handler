package com.example.demospringreactiveerrorhandler;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/greeting")
public class HelloController {

    @GetMapping("{name}")
    public Mono<String> hello(@PathVariable String name) {
        if(name.length()<2) {
            throw new MissingNameException("A name must longer than 1 character");
        }
        return Mono.just(String.format("Hello, %s!", name));
    }
}
