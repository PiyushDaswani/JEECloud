package com.cg.labthree.ui;

import java.util.HashMap;

import com.cg.labthree.dto.LabThree;

public class myApp {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,4,5,3,6};
		LabThree l = new LabThree();
		System.out.println(l.getSecondSmallest(arr));
		String[] stringArray = {"Hell","aaaa","Nice","wowo","josh","john"};
		stringArray = l.getSortedArray(stringArray);
		for (String s: stringArray) {
			//System.out.println(s);
		}
		int[] numbers = {123,252,432,343,654,314,532};
		numbers = l.getSorted(numbers);
		System.out.println("-------------------------------");
		for(int num: numbers) {
			System.out.println(num);
		}
		
		char[] characters = {'a','a', 'c', 'b', 'd','b', 'd', 'z'};
		HashMap<String, Integer> map = l.countChar(characters);
		for (String key:map.keySet()) {
			System.out.println("The number of " + key + " = " + map.get(key));
		}
	}
}
