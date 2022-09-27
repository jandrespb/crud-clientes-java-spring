package spring.ejemplo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
	
	public static void main(String[] args) {
		
		var password = "123user";
		
		System.out.println("password user: " + password);
		System.out.println("password user encriptado: " + encriptarPassword(password));
		
	}
	
	// Creamos método estático para encriptar el password
	public static String encriptarPassword(String password) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

}
