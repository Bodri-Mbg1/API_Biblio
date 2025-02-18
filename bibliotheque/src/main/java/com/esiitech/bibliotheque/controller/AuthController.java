package com.esiitech.bibliotheque.controller;

import com.esiitech.bibliotheque.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> loginRequest) {
        String token = authService.authenticate(loginRequest.get("email"), loginRequest.get("password"));
        return ResponseEntity.ok(Map.of("token", token));
    }
}
