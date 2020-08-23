package fr.asuniia.akpi.pi.modules;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;

public class API_security {
	
	public static String encryptSafe(String text,String type) {
	    try{
	        MessageDigest digest = MessageDigest.getInstance(type);
	        byte[] hash = digest.digest(text.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
	
	public static String encryptUnsafe(String text) {
		return Base64.getEncoder().encodeToString(text.getBytes());
	}
	

}
