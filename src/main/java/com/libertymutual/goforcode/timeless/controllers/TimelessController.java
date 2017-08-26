package com.libertymutual.goforcode.timeless.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.libertymutual.goforcode.timeless.models.FilePrinter;
import com.libertymutual.goforcode.timeless.models.Record;
import com.libertymutual.goforcode.timeless.models.TimeUpdate;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Controller
@RequestMapping( {"/"} )
public class TimelessController 
{ 
    
	public double[] submData = new double[5];
	public String[] record   = new String[7];
	public Date   WeekDate;
	public String dateW;
	public double total; 
	
	String pattern = "MM/dd/yyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	
	// List of ArrayLists
	Record rec = new Record();
	ArrayList<List<String>> listRecords = new ArrayList<List<String>>();
	
	
	
	@GetMapping("")    
	public String index(Model model)   { 		
		TimeUpdate upd = new TimeUpdate(model,  0, "");   // ??????
		model.addAttribute("visibilitySubmData", false);
		return "tml/default";  }

	
	 
	@PostMapping("/update")
	public String update(Model model, double[] hour_week, Date week_date, String action) throws IOException {
		
		WeekDate = week_date; 
		dateW = simpleDateFormat.format(week_date);		
		TimeUpdate upd = new TimeUpdate();
		total = upd.sumDailyHoursForTotal(hour_week);
		
		
		// Updates 'Total'		
		if (action.equals("update")) {
			model.addAttribute("visibilitySubmData", false);
								
			upd.getUpdateData(hour_week, week_date, submData);					
			upd.persistDailyHours(model, hour_week, total, dateW);
		} 
		
		else if (action.equals("submit")) {
			
			model.addAttribute("visibilitySubmData", true);
			
			upd.getUpdateData(hour_week, week_date, submData);
			upd.persistDailyHours(model, hour_week, total, dateW);
			
			// List<String[]>   List<List<String>> csvList = new ArrayList<List<String>>();
			
			// Record rec = new Record();
	        // List<String> items = upd.getAllRecords(rec.convertRecordToList(hour_week, total, dateW));
			List<List<String>> items = upd.getAllRecords(listRecords, rec.convertRecordToList(hour_week, total, dateW));
	        model.addAttribute("ListOfEntries", items);
	        
	        
			// send to the form
			total = upd.sumDailyHoursForTotal(submData);
			upd.submitWeeklyHours(model, submData, total, dateW);
			
			
			// print to a file
			FilePrinter prnt = new FilePrinter("tm.csv"); 
			prnt.printToFile(submData, dateW, total);
		}
		
		return "tml/default";
	}

}


