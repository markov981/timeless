package com.libertymutual.goforcode.timeless.models;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;




public class FilePrinter {

	private String FileName;
	public FilePrinter(String FileName) {this.FileName = FileName;} 
	
	
	public void printToFile(double[] hours, String week_f, double total) throws IOException {    	
    	   	
		FileWriter wrt = new FileWriter(FileName, true);		
        CSVPrinter printer = CSVFormat.DEFAULT.print(wrt);
        
        String[] arr = new String[7];
	        arr[0] = week_f;
	        arr[1] = String.valueOf(hours[0]);
	        arr[2] = String.valueOf(hours[1]);
	        arr[3] = String.valueOf(hours[2]);
	        arr[4] = String.valueOf(hours[3]);
	        arr[5] = String.valueOf(hours[4]);
	        arr[6] = String.valueOf(total);
		    
		printer.printRecord(arr); 
		printer.close();
    }
	
	
	public String[] readFromFile(double[] hours, String week_f, double total) throws IOException {    	
	   	
		String[] arrTo = new String[7];
								
		FileReader fr = new FileReader(FileName);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(fr);  
				
    	for (CSVRecord itrt : records) 
    	{	    	    
    		arrTo[0] = itrt.get(0); 
    		arrTo[1] = itrt.get(1); 
    		arrTo[2] = itrt.get(2); 
    		arrTo[3] = itrt.get(3); 
    		arrTo[4] = itrt.get(4); 
    		arrTo[5] = itrt.get(5); 
    		arrTo[6] = itrt.get(6); 
	    }  		
    	return arrTo; 
    }
	
	

}