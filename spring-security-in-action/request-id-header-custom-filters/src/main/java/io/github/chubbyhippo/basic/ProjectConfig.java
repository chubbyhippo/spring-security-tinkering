package io.github.chubbyhippo.basic;

import io.github.chubbyhippo.basic.filters.AuthenticationLoggingFilter;
import io.github.chubbyhippo.basic.filters.RequestValidationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class ProjectConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.addFilterBefore(new RequestValidationFilter(),
                        BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthenticationLoggingFilter(),
                        BasicAuthenticationFilter.class)
                .authorizeHttpRequests(registry ->
                        registry.anyRequest().permitAll());

        return http.build();
    }
}
