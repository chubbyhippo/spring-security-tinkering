package io.github.chubbyhippo.basic;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class HelloController {

//    @GetMapping("/hello")
//    public String hello() {
//        var securityContext = SecurityContextHolder.getContext();
//        var authentication = securityContext.getAuthentication();
//
//        return "Hello, %s".formatted(authentication.getName());
//    }

    @GetMapping("/hello")
    @Async
    public CompletableFuture<String> hello(Authentication authentication) {
        return CompletableFuture.completedFuture("Hello, %s".formatted(authentication.getName()));
    }
}
