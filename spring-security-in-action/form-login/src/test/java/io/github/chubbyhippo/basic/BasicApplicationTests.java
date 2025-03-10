package io.github.chubbyhippo.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BasicApplicationTests {

    @Autowired
    private MockMvcTester mockMvcTester;

    @Test
    @DisplayName("should redirect to login")
    void shouldRedirectToLogin() {
        mockMvcTester.get()
                .uri("/home")
                .assertThat()
                .redirectedUrl()
                .endsWith("/login");
    }

    @Test
    @DisplayName("should return home")
    @WithUserDetails("matthew")
    void shouldReturnHome() {
        mockMvcTester.get()
                .uri("/home")
                .assertThat()
                .hasViewName("home.html");
    }
}
