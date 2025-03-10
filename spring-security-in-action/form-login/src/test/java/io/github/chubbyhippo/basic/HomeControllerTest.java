package io.github.chubbyhippo.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

@WebMvcTest
@WithMockUser
class HomeControllerTest {
    @Autowired
    private MockMvcTester mockMvcTester;

    @Test
    @DisplayName("should return home")
    void shouldReturnHello() {
        mockMvcTester.get()
                .uri("/home")
                .assertThat()
                .hasStatusOk()
                .hasViewName("home.html");
    }
}
