package io.github.chubbyhippo.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(registry ->
                        registry.anyRequest().authenticated()
//                        registry.anyRequest().permitAll()
        );

        var user = User.withUsername("matthew")
                .password("12345")
                .authorities("read")
                .build();

        var userDetailsService = new InMemoryUserDetailsManager(user);
        http.userDetailsService(userDetailsService);

        return http.build();
    }

//    @Bean
//    UserDetailsService userDetailsService() {
//
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
