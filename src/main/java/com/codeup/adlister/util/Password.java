package com.codeup.adlister.util;

import org.mindrot.jbcrypt.BCrypt;

public class Password {
	
	private static final int HASH_ROUNDS = 12;
	
	public static String hash(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(HASH_ROUNDS));
	}
	
	public static boolean check(String password, String hash) {
		return BCrypt.checkpw(password, hash);
	}
}
