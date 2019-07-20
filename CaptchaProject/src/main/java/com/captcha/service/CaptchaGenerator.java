package com.captcha.service;

public class CaptchaGenerator {
		
	public static String generateCaptchaTextMethod2(int captchaLength) 	 {
		String saltChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuffer captchaStrBuffer = new StringBuffer();
		java.util.Random rnd = new java.util.Random();

		// build a random captchaLength chars salt        
		while (captchaStrBuffer.length() < captchaLength){
			int index = (int) (rnd.nextFloat() * saltChars.length());
			captchaStrBuffer.append(saltChars.substring(index, index+1));
		}

		return captchaStrBuffer.toString();
	}
}
