package com.cg.labfive.ui;

import com.cg.labfive.dto.LabFive;
import java.util.Scanner;

public class MyApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LabFive l = new LabFive();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice\n1.Red\n2. Yellow\n3. Green");
		int inp = sc.nextInt();
		System.out.println(l.trafficLight(inp));
		sc.close();
		String[] arr = {};
	}

}
