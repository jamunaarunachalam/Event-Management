package com.example.event.service;


import java.util.List;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.event.dto.Request.AuthenticationRequest;
import com.example.event.dto.Request.RegisterRequest;
import com.example.event.dto.Response.AuthenticationResponse;
import com.example.event.entity.registerentity;

import com.example.event.repository.UserRegisterRepository;
import com.example.event.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AuthenticationService {
    private final UserRegisterRepository repository ; 
	private final UserRepository userRepository;
	 private final PasswordEncoder passwordEncoder;
	 private final JwtService jwtservice;
	 private final AuthenticationManager authenticationManager;
	public AuthenticationResponse register(RegisterRequest request) {
		// TODO Auto-generated method stub
	
			
	    var user = registerentity.builder()
	            .username(request.getUsername())
	            .emailid(request.getEmailid())
	            .mobileno(request.getMobileno())
	            .password(passwordEncoder.encode(request.getPassword()))
	            .role(request.getRole())
	            .build();
	    repository.save(user); 
	    var jwtToken = jwtservice.generateToken(user);
	    
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
				request.getUsername(),
				request.getPassword()
				)
				);
				var user = repository.findByUsername(request.getUsername())
						.orElseThrow();
				 var jwtToken = jwtservice.generateToken(user);
				    
					return AuthenticationResponse.builder()
							.token(jwtToken)
							.role(user.getRole().toString())
							.build();
	}
	public List<registerentity> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    

	
    
}

	
    


