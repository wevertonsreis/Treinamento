package com.system.validations;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityMd5 {
	
	public static String transform(String word){
		
		String wordTransformed = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			BigInteger has = new BigInteger(1, md.digest(word.getBytes()));
			wordTransformed = has.toString(16);
		} 
		catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wordTransformed;
	}
}