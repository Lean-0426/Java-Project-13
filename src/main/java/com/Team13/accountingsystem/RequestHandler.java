package com.Team13.accountingsystem;

import java.util.List;
import java.util.ArrayList;

// RecordIndex를 가져와 요청 처리하는 클래스
public class RequestHandler {
	private final RecordIndex recordIndex;
	private List<String> transactionCategoryList;
	
	public RequestHandler(RecordIndex recordIndex, List<String> transactionCategoryList) {
		this.recordIndex = recordIndex;
		this.transactionCategoryList = transactionCategoryList;
	}
	
	public List<Record> requestForCategory(String Category) {
		List<Record> records = recordIndex.getByCategory(Category);
	// 특정 Type의 transaction이 있는지 확인하는 메소드
		if (records.isEmpty()) {
			System.out.printf("There are no such transactions with Category: %s\n", Category);
			return records;
		}
		else {
			return records;
		}
	}

	public List<List<Record>> sortByCategory() {
		List<List<Record>> recordsByCategory = new ArrayList<List<Record>>(); 
		for (String Category : this.transactionCategoryList) {
			recordsByCategory.add(recordIndex.getByCategory(Category));
		}
		return recordsByCategory;
	}
	
	public Analysis getSummaryAnalysisData(List<Record> records, String analysisName) {
		Analysis analysis = new Analysis(records, analysisName);
		return analysis;
	}
	
	
}
