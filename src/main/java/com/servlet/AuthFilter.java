package com.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        Optional<Cookie> user = Arrays.stream(cookies)
                .filter(c -> c.getName().equals("user"))
                .findAny();
        if (user.isPresent()) {
            filterChain.doFilter(servletRequest, servletResponse);
            servletResponse.getWriter().write("user" + user.get().getValue());
        } else {
            servletResponse.getWriter().write("Go to Login");
        }
    }

    @Override
    public void destroy() {

    }
}
