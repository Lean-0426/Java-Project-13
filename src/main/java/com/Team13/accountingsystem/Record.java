package com.Team13.accountingsystem;

import java.time.LocalDateTime;

public class Record {
	private final Integer recID;
	private final LocalDateTime transactionDateTime;
	private final Double transactionAmount;
	private final String accountNo;
	private final String accountName;
	private String transactionType;
	private String description;
	
	// Methods
	// Constructors
	public Record(Integer recID, LocalDateTime transactionDateTime, Double transactionAmount, String accountNo, String accountName, String transactionType, String description) {
		this.recID = recID;
		this.transactionDateTime = transactionDateTime;
		this.transactionAmount = transactionAmount;
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.transactionType = transactionType;
		this.description = description;
	}
	
	
	// getters and setters
	public Integer getID() {return this.recID;}
	public LocalDateTime getTransactionDateTiem() {return this.transactionDateTime;}
	public Double getTransactionAmount() {return this.transactionAmount;}
	public String getAccountNo() {return this.accountNo;}
	public String getAccountName() {return this.accountName;}
	public String getDescription() {return this.description;}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTransactionType() {return this.transactionType;}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	@Override
	public String toString() {
		return String.format("%10s %20s %10.2f %14s %14s %20s %20s\n", recID, 
				transactionDateTime, transactionAmount, 
				accountNo, accountName, transactionType, description);
	}
	
}
