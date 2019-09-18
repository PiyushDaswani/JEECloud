package com.cg.labthree.dto;

import java.util.Arrays;
import java.util.HashMap;

public class LabThree {

	public int getSecondSmallest(int[] arr) {
		Arrays.sort(arr);
		System.out.println(arr);
		return arr[1];
	}
	
	public String[] getSortedArray(String[] arr) {
		for(int i = 0; i<arr.length-1; i++) {
			for (int j = i+1; j<arr.length; j++) {
	           if(arr[i].toLowerCase().compareTo(arr[j].toLowerCase())>0) {
	              String temp = arr[i];
	              arr[i] = arr[j];
	              arr[j] = temp;
	           }
			}
	    }
		for (int i = 0; i<arr.length/2; i++) {
			arr[i] = arr[i].toUpperCase();
		}
		for (int i = arr.length/2; i<arr.length; i++) {
			arr[i] = arr[i].toLowerCase();
		}
		return arr;
	}
	
	public int[] getSorted(int[] arr){
		for(int i = 0; i<arr.length; i++){
			String num = Integer.toString(arr[i]);
			StringBuffer number = new StringBuffer(num);
			number.reverse();
			arr[i] = Integer.parseInt(number.toString());
			System.out.println(arr[i]);
		}
		Arrays.sort(arr);
		return arr;
	}
	public HashMap<String, Integer> countChar(char[] arr){
		HashMap<String,Integer> count = new HashMap<String,Integer>();
		for(char a:arr) {
			String s = String.valueOf(a);
			if(count.containsKey(s)) 
				count.put(s, count.get(s) + 1);
			else 
				count.put(s,1);
		}
		
		return(count);
	}
	
}

	
