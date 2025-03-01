package io.github.chubbyhippo.basic;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String hello(Authentication authentication) {
        return "Hello, %s".formatted(authentication.getName());
    }
}
