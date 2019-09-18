package com.cg.labfive.dto;

public class LabFive {
	 public String trafficLight(int x) {
	 	switch(x){
	 		case 1:{
	 			return("Stop");
	 		}
	 		case 2:{
	 			return("Ready");
	 		}
	 		case 3:{
	 			return ("Go");
	 		}
	 		default:{
	 			return(null);
	 		}
	 	}
	 }
}
