package com.example.event.dto.Request;




import com.example.event.entity.enumerate.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor  
@NoArgsConstructor
public class RegisterRequest{
	private String username;
	private String emailid;
	private String mobileno;
	private String password;
	private Role role;
}
