package com.Team13.accountingsystem;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import com.opencsv.CSVReader;
import java.time.LocalDateTime;

public class CSVFileHandler {
	private final String filePath;
	
	// Constructor
	public CSVFileHandler(String filePath) {
		this.filePath = filePath;
	}
	
	// getters & setters
	public String getFilePath() {
		return filePath;
	}

	// Function to read the file and return the data as an ArrayList of strings 
	public List<Record> readFile() {
		List<Record> recordList = new ArrayList<>();
		DateTimeFormatter dtFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME; // e.g. 2025-05-14T15:30
		int lineCounter = 0;
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(this.filePath);
		if (inputStream != null) {
			try (CSVReader reader = new CSVReader(new InputStreamReader(inputStream))){
				String[] line; // buffer to store read line
				reader.readNext(); // skip header
				while ((line = reader.readNext()) != null) {
					lineCounter += 1;
					try {
						Integer id = Integer.parseInt(line[0]);
						LocalDateTime dt = LocalDateTime.parse(line[1], dtFormatter);
						Double amt = Double.parseDouble(line[2]);
						Record r = new Record(id,dt,amt,line[3],line[4],line[5],line[6]);
						recordList.add(r); 
					}
					catch (Exception e){
						System.out.printf("Error when processing line: %d\n", lineCounter);
						e.printStackTrace();
					}
				}
			}
			catch (Exception e) {
				System.out.printf("Error when trying to read file: %s\n", this.filePath);
				e.printStackTrace();
			}
		}
		else {
			 System.out.println("File not found in resources!");
		}
		return recordList;
	}
	
	
}
