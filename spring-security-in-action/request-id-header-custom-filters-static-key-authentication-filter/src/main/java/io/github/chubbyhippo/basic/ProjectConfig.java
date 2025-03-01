package io.github.chubbyhippo.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class ProjectConfig {
    private final StaticKeyAuthenticationFilter staticKeyAuthenticationFilter;

    public ProjectConfig(StaticKeyAuthenticationFilter staticKeyAuthenticationFilter) {
        this.staticKeyAuthenticationFilter = staticKeyAuthenticationFilter;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.addFilterAt(staticKeyAuthenticationFilter,
                        BasicAuthenticationFilter.class)
                .authorizeHttpRequests(registry ->
                        registry.anyRequest().permitAll());
        return http.build();
    }
}
