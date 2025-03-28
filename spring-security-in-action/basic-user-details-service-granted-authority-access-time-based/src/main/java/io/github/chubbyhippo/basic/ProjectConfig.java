package io.github.chubbyhippo.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

@Configuration
public class ProjectConfig {

    @Bean
    UserDetailsService userDetailsService() {
        var manager = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("matthew")
                .password("12345")
                .authorities("read")
                .build();

        var user2 = User.withUsername("mark")
                .password("12345")
                .authorities("read", "write", "delete")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);

        return manager;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(registry ->
                registry.anyRequest()
                        // allow only after 12:00 pm
                        .access(new WebExpressionAuthorizationManager("""
                                T(java.time.LocalTime).now().isAfter(T(java.time.LocalTime).of(12, 0))
                                """))
        );
        return http.build();
    }
}
