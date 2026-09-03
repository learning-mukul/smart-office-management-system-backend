package com.mukul.app.controller;

import com.mukul.app.dto.AuthRequest;
import com.mukul.app.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager){
        this.authenticationManager=authenticationManager;
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest){
        try{
            Authentication authentication =authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())

            );
            if(authentication.isAuthenticated()){
                return JwtUtil.generateToken(authRequest.getUsername());
            }else{
                throw new RuntimeException("Invalid Credentials");
            }

        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid Credentials");
        }
    }

}
