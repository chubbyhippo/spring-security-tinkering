package io.github.chubbyhippo.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    public ProjectConfig(CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler, CustomAuthenticationFailureHandler customAuthenticationFailureHandler) {
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
        this.customAuthenticationFailureHandler = customAuthenticationFailureHandler;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.formLogin(configurer ->
                configurer.successHandler(customAuthenticationSuccessHandler)
                        .failureHandler(customAuthenticationFailureHandler));
        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(registry ->
                registry.anyRequest().authenticated());

        return http.build();
    }

}
