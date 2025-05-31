package com.Team13.accountingsystem;

public class App {
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
    }
}
