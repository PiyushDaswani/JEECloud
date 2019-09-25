package com.cg.labeight.ui;

import java.util.Scanner;

import com.cg.labeight.dto.FileReadingClass;
import com.cg.labeight.dto.StringCounter;
import com.cg.labeight.dto.SumOfIntegers;

public class MyApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the numbers seperated by ,");
		String line = sc.next();
		SumOfIntegers s = new SumOfIntegers();
		System.out.println(s.sumOfInt(line));
		System.out.println("\n------------------------------------------------------\n");
		FileReadingClass fr = new FileReadingClass();
		fr.readFile();
		System.out.println("\n------------------------------------------------------\n");
		System.out.println("Enter the string");
		sc.nextLine();
		String str = sc.nextLine();
		StringCounter strc = new StringCounter();
		strc.printNoOf(str);
		sc.close();
	}
	
}
