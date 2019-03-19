package com.tahometer.volodymyrpoli.todolistapp.security.controller;

import lombok.Data;

@Data
public class JwtAuthenticationRequest {

    private String username;
    private String password;

}
