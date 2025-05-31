package com.Team13.accountingsystem;

import java.util.List; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class RecordIndex {
	private final List<Record> allRecords;
	private final Map<String, List<Record>> typeIndex = new HashMap<>();
	
	public RecordIndex(List<Record> records) {
		this.allRecords = records;
		buildIndexes();
	}
	
	// allRecords의 레코드들을 TransactionType을 key, list를 value로 grouping하여 TypeIndex라는 Map 형성
	private void buildIndexes() {
		for (Record r : allRecords) {
			/* Index by type */
			typeIndex.computeIfAbsent(r.getTransactionType(), key -> new ArrayList<Record>()).add(r);
		}
	}
	
	// why safe? 
	public List<Record> getByType(String type) {
		/** performs a safe lookup to a map (typeIndex), returns value (arraylist) of the key (type) if exists 
		 	and defaultValue (immutable empty list, from collections.emptyList, prevents NullPointer exception) if not */ 
		return typeIndex.getOrDefault(type, Collections.emptyList());
	}
	
	// add record and add it to typeIndex
	public void addRecordIndex(Record r) {
		/* updates the index structures */
		allRecords.add(r);
		typeIndex.computeIfAbsent(r.getTransactionType(), key -> new ArrayList<>()).add(r);
	}
	
	
}
