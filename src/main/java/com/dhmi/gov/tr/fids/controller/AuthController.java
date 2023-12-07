package com.dhmi.gov.tr.fids.controller;

import com.dhmi.gov.tr.fids.domain.dto.LoginRequestDto;
import com.dhmi.gov.tr.fids.domain.dto.LoginResponseDto;
import com.dhmi.gov.tr.fids.domain.dto.RegisterRequestDto;
import com.dhmi.gov.tr.fids.security.service.AuthenticationService;
import com.dhmi.gov.tr.fids.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticateUser(@Valid @RequestBody LoginRequestDto loginRequest) {
        return authenticationService.authenticateLoginRequest(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequestDto request) {
        return userService.create(request);
    }
}
