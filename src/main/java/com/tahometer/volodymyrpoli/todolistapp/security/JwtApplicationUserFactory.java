package com.tahometer.volodymyrpoli.todolistapp.security;

import com.tahometer.volodymyrpoli.todolistapp.entity.ApplicationUser;

public class JwtApplicationUserFactory {

    private JwtApplicationUserFactory() {
    }

    public static JwtApplicationUser create(ApplicationUser user) {
        return new JwtApplicationUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail()
        );
    }

}
