package com.dezo.e_com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dezo.e_com.model.LoginRequest;
import com.dezo.e_com.model.LoginResponse;
import com.dezo.e_com.model.UserProfile;
import com.dezo.e_com.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  private UserService userService;

  @Autowired
  private PasswordEncoder pwdEncoder;

  @GetMapping("")
  public String checkCredentials() {
    // System.out.println("Payload" + user.toString());
    return "It's working";
  }

  // public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest,HttpSession session) {
  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
    System.out.println("LoginRequest" + loginRequest);
    // System.out.println("session"+ session);
    try {
      return userService.authenticate(loginRequest.getEmail(),loginRequest.getPassword());
    } catch (Error e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(null,"An unknown error occurred"));
    }
  }

  @PostMapping("/register")
  // public void register(@RequestBody LoginRequest loginRequest) {
  public ResponseEntity<String> register(@RequestBody UserProfile user) {
    System.out.println("USER \n" + user);
       if(userService.createNewUser(user)){
        return ResponseEntity.ok().body("User was created succeffuly.");
      }
      return ResponseEntity.badRequest().body("Something went off");
    }

}
