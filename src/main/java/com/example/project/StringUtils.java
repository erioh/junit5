package com.example.project;

public class StringUtils {
	public static boolean isPalindrome(String str){
		if (str == null)
			return false;
		int len  = str.length();
		for (int i=0;i<len/2 ; i++){
			if (str.charAt(i) != str.charAt(len - i - 1)){
				return false;
			}
		}
		return true;
	}
}
