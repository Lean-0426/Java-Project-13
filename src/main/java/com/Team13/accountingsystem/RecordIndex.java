package com.Team13.accountingsystem;

import java.util.List; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class RecordIndex {
	private final List<Record> allRecords;
	private final Map<String, List<Record>> categoryIndex = new HashMap<>();
	private final Map<String, List<Record>> bankIndex = new HashMap<>();
	public RecordIndex(List<Record> records) {
		this.allRecords = records;
		buildIndexes();
	}
	
	private void buildIndexes() {
		for (Record r : allRecords) {
			/* Index by category */
			categoryIndex.computeIfAbsent(r.getTransactionCategory(), key -> new ArrayList<Record>()).add(r);
		}
	}
	
	public List<Record> getByCategory(String category) {
		/** performs a safe lookup to a map (categoryIndex), returns value (arraylist) of the key (category) if exists 
		 	and defaultValue (immutable empty list, from collections.emptyList, prevents NullPointer exception) if not */ 
		return categoryIndex.getOrDefault(category, Collections.emptyList());
	}
	
	
	public void addRecordIndex(Record r) {
		/* updates the index structures */
		allRecords.add(r);
		categoryIndex.computeIfAbsent(r.getTransactionCategory(), key -> new ArrayList<>()).add(r);
	}
	
	
}
