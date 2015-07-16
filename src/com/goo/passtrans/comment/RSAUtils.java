package com.goo.passtrans.comment;

import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class RSAUtils {
	public static String encrypt(String publicKey, String plainTextData) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(new BigInteger(publicKey.getBytes()), new BigInteger("3".getBytes()));
			Key key = keyFactory.generatePublic(pubKeySpec);
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] output = cipher.doFinal(plainTextData.getBytes());
			return Base64.encodeBase64String(output);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		String publicKey = "jW1n+lnW9jfV117Pw2lobOOCQ1PchPH1X8z1I3M3A+o5o1rQcP5H1sA15ZX67OLOOOJWe7Me7iurMjmB1jP+uw==";

		String h = Hex.encodeHexString(Base64.decodeBase64(publicKey));
		System.out.println(h);
		String res = RSAUtils.encrypt(publicKey, "gaobiao,123");
		System.out.println(res);
	}
}
