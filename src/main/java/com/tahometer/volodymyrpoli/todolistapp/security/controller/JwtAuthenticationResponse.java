package com.tahometer.volodymyrpoli.todolistapp.security.controller;

import lombok.Getter;

@Getter
public class JwtAuthenticationResponse {

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }
}
