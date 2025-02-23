package io.github.chubbyhippo.basic;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class AuthenticationLoggingFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationLoggingFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) servletRequest;

        var requestId = httpRequest.getHeader("Request-Id");
        log.info("Successfully authenticated wit Request-Id: {}", requestId);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
