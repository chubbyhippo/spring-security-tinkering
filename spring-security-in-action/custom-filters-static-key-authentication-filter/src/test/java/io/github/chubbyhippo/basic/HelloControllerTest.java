package io.github.chubbyhippo.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

@WebMvcTest
@WithMockUser
class HelloControllerTest {
    @Autowired
    private MockMvcTester mockMvcTester;

    @Test
    @DisplayName("should return hello")
    void shouldReturnHello() {
        mockMvcTester.get()
                .uri("/hello")
                .header("Authorization", "authorizationKey")
                .assertThat()
                .hasStatusOk()
                .doesNotHaveFailed()
                .hasContentType("text/plain;charset=UTF-8")
                .hasBodyTextEqualTo("Hello!");
    }
}
