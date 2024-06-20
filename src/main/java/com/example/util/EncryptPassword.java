package com.example.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPassword {
	
	/*
	 * public static void main(String[] args) { var password1;
	 * System.out.println("User password: " + password1);
	 * System.out.println("Encrypted user password: " + encryptPassword(password1));
	 * }
	 */
	 

	public static String encryptPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

}
