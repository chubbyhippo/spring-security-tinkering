package io.github.chubbyhippo.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import java.util.Base64;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		args = "--spring.security.user.password=password" )
@TestPropertySource(properties = "spring.security.user.name=hello")
@AutoConfigureMockMvc
class BasicApplicationTests {
	@Autowired
	private MockMvcTester mockMvcTester;

	@Test
	@DisplayName("should return hello")
	void shouldReturnHello() {
		var base64 = Base64.getEncoder().encodeToString("hello:password".getBytes());
		mockMvcTester.get()
				.uri("/hello")
				.header( "Authorization", "Basic %s".formatted( base64))
				.assertThat()
				.hasStatusOk()
				.doesNotHaveFailed()
				.hasContentType("text/plain;charset=UTF-8")
				.hasBodyTextEqualTo("Hello!");
	}

}
