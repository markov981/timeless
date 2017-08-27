package com.libertymutual.goforcode.timeless.models;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.ui.Model;


public class TimeUpdate {
	
	private double hoursPerWeek; 
	
	// ????
	public TimeUpdate() {}
	public TimeUpdate(Model model, double num, String w_d) { initializeDailyHours(model, num, w_d); }
	
	
	
	public double sumDailyHoursForTotal(double[] weeklyHours) {	
		double hours = 0; 
		
		for(int i = 0; i < weeklyHours.length; i++) {
			System.out.println(i + "  " + weeklyHours[i]); 
			hours += weeklyHours[i];}	
		
		return hours;
	}
	
	

	public ArrayList<ArrayList<String>> getAllRecords(ArrayList<String> record, ArrayList<ArrayList<String>> rec){	
		rec.add(new ArrayList<>(record));	
		return rec;
	}
	

//	public ArrayList<String> getAllRecords(String[] record)
//	{		
//		ArrayList<String> listRecords = new ArrayList<String>(Arrays.asList(record));
//		return listRecords;
//	}	
	
	
	public void initializeDailyHours(Model model, double num, String week_d) {			
		model.addAttribute("mon", num);
		model.addAttribute("tue", num);
		model.addAttribute("wed", num);
		model.addAttribute("thu", num);
		model.addAttribute("fri", num);
		
		model.addAttribute("total", num);
		model.addAttribute("week_d", week_d);
	}

	
	
	public void persistDailyHours(Model model, double[] hour_week, double total, String week_d) {
		
		model.addAttribute("week_d", week_d);
		model.addAttribute("mon", hour_week[0]);
		model.addAttribute("tue", hour_week[1]);
		model.addAttribute("wed", hour_week[2]);
		model.addAttribute("thu", hour_week[3]);
		model.addAttribute("fri", hour_week[4]);
		model.addAttribute("total", total);	

//		model.addAttribute("monday", hour_week[0]);
//		model.addAttribute("tuesday", hour_week[1]);
//		model.addAttribute("wednesday", hour_week[2]);
//		model.addAttribute("thursday", hour_week[3]);
//		model.addAttribute("friday", hour_week[4]);			

	}
	
	
	
	public void submitWeeklyHours(Model model, double[] WeekHours, double total, String week_of) {	
//		model.addAttribute("week_of", week_of);
		model.addAttribute("week_d", "");
		
//		model.addAttribute("monday", WeekHours[0]);
//		model.addAttribute("tuesday", WeekHours[1]);
//		model.addAttribute("wednesday", WeekHours[2]);
//		model.addAttribute("thursday", WeekHours[3]);
//		model.addAttribute("friday", WeekHours[4]);	
		
		model.addAttribute("mon", 0);
		model.addAttribute("tue", 0);
		model.addAttribute("wed", 0);
		model.addAttribute("thu", 0);
		model.addAttribute("fri", 0);
		
		model.addAttribute("total", 0);}

	
	
	public double[]  getUpdateData(double[] hour_week, Date week_date, double[] WeekHrs) {
	
		for(int i = 0; i < WeekHrs.length - 1; i++)
			WeekHrs[i] = hour_week[i];
		
		return WeekHrs;
	}
}
  
