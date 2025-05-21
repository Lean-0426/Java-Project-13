package com.Team13.accountingsystem;

import java.util.ArrayList;
import java.util.List;

/* Depending on the type of analysis available we might need to branch it out more */
public class Analysis {
	private List<Record> records;
	private double totalAmt;
	private double averagePerTxn;
	private double maxTxnAmt;
	private double minTxnAmt;
	private String name;
	
	/* Constructors */
	public Analysis(List<Record> records, String analysisName) {
		this.records = records;
		this.name = analysisName;
		analyse();
		
	}
	
	/* methods */
	public void analyse() {
		this.totalAmt = 0;
		this.maxTxnAmt = 0; 
		this.minTxnAmt = this.records.get(0).getTransactionAmount();
		for (Record r : records) {
			double current = r.getTransactionAmount();
			totalAmt += current;
			if (this.maxTxnAmt < current) {
				this.maxTxnAmt = current;
			}
			if (this.minTxnAmt > current) {
				this.minTxnAmt = current;
			}
		}
		this.averagePerTxn = this.totalAmt/records.size();
	}
	
	/* getters and setters */
	public double getTotalAmt() {
		return this.totalAmt;
	}
	public double getAveragePerTxn() {
		return this.averagePerTxn;
	}
	public double getMaxTxnAmt() {
		return this.maxTxnAmt;
	}
	public double getMinTxnAmt() {
		return this.minTxnAmt;
	}
	public List<Record> getRecords() {
		return this.records;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
