package com.jrbrayjr.spring.security.securityservice.controller;

import com.jrbrayjr.spring.security.securityservice.model.Login;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping( value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Void> login(@RequestBody Login login) {
        ResponseEntity<Void> response = ResponseEntity.ok().build();

        return response;
    }
}
