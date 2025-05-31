package com.Team13.accountingsystem;

import java.util.List;
import java.util.Map;

public class BankAccount {
	private String accountNo;
	private String accountName;
	private Double totalAmount;
	private Analysis bankAccountAnalysis;
	private String bankName;
	private List<Record> recordList;
	/* Constructors */
	public BankAccount(String bankName, String accountNo, List<Record> recordList) {
		this.bankName = bankName;
		this.accountNo = accountNo;
		this.accountName =  this.bankName + this.accountNo;
		this.recordList = recordList;
	}
	
	public BankAccount(String bankName, String accountNo, String accountName, List<Record> recordList) {
		this.bankName = bankName;
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.recordList = recordList;
	}
	
	/* getters and setters */
	
	public String getAccountNo() {
		return this.accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return this.accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getBankName() {
		return this.bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Double getTotalAmount() {
		return this.totalAmount;
	}
	
	
	/* methods */
	public Double calculateTotalAmount() {
		return 0.0;
	}
}
