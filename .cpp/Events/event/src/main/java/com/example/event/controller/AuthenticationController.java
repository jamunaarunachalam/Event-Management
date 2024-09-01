package com.example.event.controller;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.event.dto.Request.AuthenticationRequest;
import com.example.event.dto.Request.RegisterRequest;
import com.example.event.dto.Response.AuthenticationResponse;
import com.example.event.entity.registerentity;

import com.example.event.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")	
@RequiredArgsConstructor
public class AuthenticationController {
	
	private final AuthenticationService service;
	@PostMapping("/register")
	 public ResponseEntity<String> register(
		      @RequestBody RegisterRequest request
		  ) {
		service.register(request);
		    return ResponseEntity.ok("Registered Successfully");
		  }
		  @PostMapping("/authenticate")
		  public ResponseEntity<AuthenticationResponse> authenticate(
		      @RequestBody AuthenticationRequest request
		  ) {
		    return ResponseEntity.ok(service.authenticate(request));
		  }
		  @PreAuthorize("hasAuthority('ADMIN')")
		  @GetMapping("/users")
		    public ResponseEntity<List<registerentity>> getAllUsers() {
		        List<registerentity> users = service.getAllUsers();
		        return ResponseEntity.ok(users);
		    }

		    @DeleteMapping("/users/{userId}")
		    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		        service.deleteUser(userId);
		        return ResponseEntity.ok("User deleted successfully");
		    }
		    


}
