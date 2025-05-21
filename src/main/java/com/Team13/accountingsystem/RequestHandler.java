package com.Team13.accountingsystem;

import java.util.List;
import java.util.ArrayList;


public class RequestHandler {
	private final RecordIndex recordIndex;
	private List<String> transactionTypeList;
	
	public RequestHandler(RecordIndex recordIndex, List<String> transactionTypeList) {
		this.recordIndex = recordIndex;
		this.transactionTypeList = transactionTypeList;
	}
	
	public List<Record> requestForType(String type) {
		List<Record> records = recordIndex.getByType(type);
		if (records.isEmpty()) {
			System.out.printf("There are no such transactions with type: %s\n", type);
			return records;
		}
		else {
			return records;
		}
	}
	
	public List<List<Record>> sortByType() {
		List<List<Record>> recordsByType = new ArrayList<List<Record>>(); 
		for (String type : this.transactionTypeList) {
			recordsByType.add(recordIndex.getByType(type));
		}
		return recordsByType;
	}
	
	public Analysis getSummaryAnalysisData(List<Record> records, String analysisName) {
		Analysis analysis = new Analysis(records, analysisName);
		return analysis;
	}
	
	
}
