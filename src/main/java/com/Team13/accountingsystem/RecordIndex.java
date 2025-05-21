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
	
	private void buildIndexes() {
		for (Record r : allRecords) {
			/* Index by type */
			typeIndex.computeIfAbsent(r.getTransactionType(), key -> new ArrayList<Record>()).add(r);
		}
	}
	
	public List<Record> getByType(String type) {
		/** performs a safe lookup to a map (typeIndex), returns value (arraylist) of the key (type) if exists 
		 	and defaultValue (immutable empty list, from collections.emptyList, prevents NullPointer exception) if not */ 
		return typeIndex.getOrDefault(type, Collections.emptyList());
	}
	
	
	public void addRecordIndex(Record r) {
		/* updates the index structures */
		allRecords.add(r);
		typeIndex.computeIfAbsent(r.getTransactionType(), key -> new ArrayList<>()).add(r);
	}
	
	
}
