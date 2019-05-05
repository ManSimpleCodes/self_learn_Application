package com.sehw.util;
import java.security.MessageDigest;
public class EncryptOrDecrypt 
{
	public static String encryptText(String str)
	{		
		String encryptpass=null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] bytes = md.digest();
			StringBuilder stb = new StringBuilder();
			for (int i=0; i<bytes.length; i++) {
				stb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			encryptpass = stb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptpass;
	}
	


}
