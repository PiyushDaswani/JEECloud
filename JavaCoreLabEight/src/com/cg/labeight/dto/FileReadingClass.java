package com.cg.labeight.dto;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReadingClass {

	public void readFile() {
		BufferedReader reader;
		try{
			reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\Desktop\\JEE Cloud\\test.txt"));
			String  nextLine = reader.readLine();
			int lineNo = 1;
			while(nextLine != null) {
				System.out.println(lineNo + ". "+ nextLine);
				nextLine = reader.readLine();
				lineNo ++;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
