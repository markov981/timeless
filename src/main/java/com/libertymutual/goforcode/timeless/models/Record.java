package com.libertymutual.goforcode.timeless.models;

public class Record {
	
	private String[] rec = new String[7];
	
	
	public String[] convertRecordToList(double[] hour_week, double total, String week_d) {
		
			rec[0] = week_d; 
			rec[6] = String.valueOf(total); 
			
			for(int i = 1; i < hour_week.length + 1; i++)
				rec[i] = String.valueOf(hour_week[i - 1]);
			
//			for (int i = 0; i < rec.length; i += 1) {
//				if (rec[i] == null) rec[i] = "";
//			}
					
	return rec;
	
	}
	

}
