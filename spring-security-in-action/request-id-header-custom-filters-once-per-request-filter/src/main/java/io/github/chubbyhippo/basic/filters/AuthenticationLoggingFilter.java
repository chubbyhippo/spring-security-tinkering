package io.github.chubbyhippo.basic.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthenticationLoggingFilter extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationLoggingFilter.class);

    @SuppressWarnings("NullableProblems")
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        var requestId = request.getHeader("Request-Id");
        log.info("Successfully authenticated wit Request-Id: {}", requestId);

        filterChain.doFilter(request, response);
    }
}
