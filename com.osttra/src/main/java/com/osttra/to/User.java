package com.osttra.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class User {
	private String username;
	private String password;
	private String completeName;
	private String email;
	private String role;
	private String status;
}
