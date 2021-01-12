package com.project.utils;

import java.util.Random;

public class GenRandom {

	public static String randomString() {
		byte[] array = new byte[7]; // length is bounded by 7
		new Random().nextBytes(array);
		String generatedString = new String(array);
		//System.out.println(generatedString);
		return generatedString;
	}

	public static int randomInteger() {
		int rNumber = (int) Math.ceil(Math.random() * 100000);
		return rNumber;
	}

}
