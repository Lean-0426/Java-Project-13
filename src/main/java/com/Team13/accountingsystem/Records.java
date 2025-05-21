package com.Team13.accountingsystem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;

public class Records {
	public List<Record> records;
	
	/* Constructors */
	public Records() {
		this.records = new ArrayList<Record>();
	}
	
	public Records(List<Record> records) {
		this.records = records;
	}
	
	/* Methods (to manage the records and get metadata) */
	public int getNumberOfRecords() {
		return records.size();
	}
	
	public boolean addRecord(Record r) {
		return records.add(r);
	}
	
	public boolean deleteRecord(int recID) {
		return records.removeIf(record -> record.getID().equals(recID));
	}
	
	public List<Record> getEmptyImmutableList() {
		return Collections.emptyList();
	}
	
	public List<Record> getAllRecords() {
		return records;
	}
	
	public List<String> getTransactionTypeList() {
		/* Through the stream function loop through records, map to transform record to the field type, 
		 * distinct to only get distinct results and collect it into a list */
		List<String> transactionTypeList = records.stream()
				.map(Record::getTransactionType).distinct().collect(Collectors.toList());
		return transactionTypeList;
	}
	
	
	/* Best to set records to private and allow edits only from this class and its functions*/
	
}
