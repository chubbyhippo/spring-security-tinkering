package io.github.chubbyhippo.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.httpBasic(configurer -> {
            configurer.realmName("CustomRealm");
            configurer.authenticationEntryPoint(new CustomEntryPoint());
        });
        http.authorizeHttpRequests(registry -> registry.anyRequest().authenticated());
        return http.build();
    }

}
