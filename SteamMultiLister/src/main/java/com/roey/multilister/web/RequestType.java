package com.roey.multilister.web;

public enum RequestType {
    GET("GET"),
    POST("POST");

    public final String value;

    RequestType(String value) {
        this.value = value;
    }
}
