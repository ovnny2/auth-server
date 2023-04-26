package com.craftzn.authserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class UserController {


    @GetMapping("/logout")
    ResponseEntity<String> homePage() {
        return ResponseEntity.ok().body("You was logged out");
    }

    @GetMapping("/users")
    ResponseEntity<String> getUserStuff() {
        return ResponseEntity.ok().body("hello, user");
    }
}