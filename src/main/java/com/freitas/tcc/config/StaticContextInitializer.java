package com.freitas.tcc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StaticContextInitializer {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    public void init() {
        StaticUtils.setApplicationProperties(applicationProperties);
    }
}