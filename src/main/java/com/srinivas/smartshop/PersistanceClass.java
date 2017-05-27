package com.srinivas.smartshop;


import java.util.ArrayList;

public class PersistanceClass {

	private static ArrayList<String> idList = new ArrayList<String>();
	
	public static ArrayList<String> getIdList(){
		return idList;
	}
	
	public static void setIdList(ArrayList<String> idArray){
		idList = idArray;
	}
}
