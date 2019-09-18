package com.cg.labfour.dto;

public class LabFour {
	public double cubes(int num) {
		double out = 0;
		while (num>0) {
			int n = num%10;
			out = out + Math.pow(n,3);
			num = num/10;
		}
		return out;
	}
}
