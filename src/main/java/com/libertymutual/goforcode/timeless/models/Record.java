package com.libertymutual.goforcode.timeless.models;

import java.util.ArrayList;
import java.util.Arrays;


public class Record {
	
	private String[] rec = new String[7];

	
	
	public ArrayList<String> convertRecordToList(double[] hour_week, double total, String week_d) {	
		
			rec[0] = week_d; 
			rec[6] = String.valueOf(total); 
			
			for(int i = 1; i < hour_week.length + 1; i++)   
				rec[i] = String.valueOf(hour_week[i - 1]);
			
			ArrayList<String> recList = new ArrayList<>(Arrays.asList(rec));
					
	return recList;	
	}
	

}
