package com.freitas.tcc.config;

public final class StaticUtils {

    private static ApplicationProperties applicationProperties;

    public static void setApplicationProperties(ApplicationProperties applicationProperties) {
        StaticUtils.applicationProperties = applicationProperties;
    }

    public static ApplicationProperties getApplicationProperties() {
        return applicationProperties;
    }

    private StaticUtils() {
    }

}