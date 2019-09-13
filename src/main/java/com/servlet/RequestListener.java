package com.servlet;


import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest servletRequest = (HttpServletRequest) servletRequestEvent.getServletRequest();
        System.out.println("Request received"
                + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
                + servletRequest.getServletPath());
    }
}
