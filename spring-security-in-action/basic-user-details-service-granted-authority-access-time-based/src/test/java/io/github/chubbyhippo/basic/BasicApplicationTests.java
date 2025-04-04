package io.github.chubbyhippo.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BasicApplicationTests {

    @Autowired
    private MockMvcTester mockMvcTester;
    private MockedStatic<LocalTime> mockedLocalTime;

    @BeforeEach
    void beforeEach() {
        mockedLocalTime = org.mockito.Mockito.mockStatic(LocalTime.class);
    }

    @Test
    @DisplayName("should allow access after 12 PM")
    @WithUserDetails("matthew")
    void shouldAllowAccessAfter12Pm() {
        mockedLocalTime.when(LocalTime::now)
                        .thenReturn(LocalTime.of(12, 0, 1));
        mockMvcTester.get()
                .uri("/hello")
                .assertThat()
                .hasStatusOk()
                .doesNotHaveFailed()
                .hasContentType("text/plain;charset=UTF-8")
                .hasBodyTextEqualTo("Hello!");
    }

}
