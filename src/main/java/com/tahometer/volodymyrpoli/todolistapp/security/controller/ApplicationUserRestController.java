package com.tahometer.volodymyrpoli.todolistapp.security.controller;

import com.tahometer.volodymyrpoli.todolistapp.security.JwtApplicationUser;
import com.tahometer.volodymyrpoli.todolistapp.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ApplicationUserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserDetailsService userDetailsService;

    @Autowired
    public ApplicationUserRestController(JwtTokenUtil jwtTokenUtil,
                                         @Qualifier("jwtUserDetailsService") UserDetailsService userDetailsService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("user")
    public JwtApplicationUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtApplicationUser user = (JwtApplicationUser) userDetailsService.loadUserByUsername(username);
        return user;
    }

}
