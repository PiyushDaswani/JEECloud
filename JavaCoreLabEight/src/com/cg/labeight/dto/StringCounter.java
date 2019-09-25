package com.cg.labeight.dto;

public class StringCounter {

	public void printNoOf(String s) {
		int charCount = 0, lineCount = 0, wordCount = 0;
		for(int i = 0; i<s.length(); i++) {
			if(s.charAt(i) == ' ') {
				wordCount ++;
			}
			else if(s.charAt(i) == '.') {
				lineCount ++;
				wordCount ++;
			}
			else {
				charCount++;
			}
		}
		System.out.println("Char Cont = "+ charCount);
		System.out.println("Line Cont = "+ lineCount);
		System.out.println("Word Cont = "+ wordCount);
	}
}
