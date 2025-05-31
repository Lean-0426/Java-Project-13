package com.Team13.accountingsystem;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Collections;
import java.util.stream.Collectors;

public class App 
{	
    public static void main( String[] args )
    {
    	/* Setup (read the file upon program start */
    	//hi
    	String filePath = "datasets/testdata1.csv";
    	CSVFileHandler csvFileHandler = new CSVFileHandler(filePath);
    	// Records to handle add data, remove data, etc. 
    	Records records = new Records(csvFileHandler.readFile());
    	// Setup the index for fast retrieving of data
    	RecordIndex recordIndex = new RecordIndex(records.getAllRecords());
    	// Might need to update as we include more functions into the request handler
    	RequestHandler requestHandler = new RequestHandler(recordIndex,records.getTransactionCategoryList());
        
    	/* Option selected: Analyse by type/category */
    	RecordVisualiser2D.printAnalysis(requestHandler.getSummaryAnalysisData(records.getAllRecords(), "All Transactions"));
    	RecordVisualiser2D.printTextRecords(requestHandler.sortByCategory());

    	
    	/*
      List<Record> allRecords = csvFileHandler.readFile();
    	
//    	for(Record r : allRecords) {
//    		System.out.println(r);
//    	}
    	
    	//AccountMenu menu = new AccountMenu();
    	//List<Record> selectedRecords = menu.selectAccountByName(allRecords);
    	
    	for(Record r: selectedRecords) {
    		System.out.println(r);
    	}
    	
    	*/
//    	// Records to handle add data, remove data, etc. 
//    	Records records = new Records(csvFileHandler.readFile());
//    	
//    	// Setup the index for fast retrieving of data
//    	RecordIndex recordIndex = new RecordIndex(records.getAllRecords());
//    	
//    	
//    	
//    	// Might need to update as we include more functions into the request handler
//    	RequestHandler requestHandler = new RequestHandler(recordIndex,records.getTransactionTypeList());
//        
//    	/* Option selected: Analyse by type/category */
//    	RecordVisualiser2D.printAnalysis(requestHandler.getSummaryAnalysisData(records.getAllRecords(), "All Transactions"));
//    	RecordVisualiser2D.printTextRecords(requestHandler.sortByType());
    }
}
