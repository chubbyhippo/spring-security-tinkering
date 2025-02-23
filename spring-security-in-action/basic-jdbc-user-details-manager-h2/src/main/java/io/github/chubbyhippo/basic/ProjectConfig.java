package io.github.chubbyhippo.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class ProjectConfig {

    @Bean
    UserDetailsService userDetailsService() {
        var user = new User("matthew", "12345", "read");
        return new InMemoryUserDetailService(List.of(user));
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
