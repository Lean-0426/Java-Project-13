package com.Team13.accountingsystem;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecordVisualiser2D{
	
	public static void printTextRecords(List<List<Record>> d2Records) {
		System.out.println("Analysis Result: ");
		for (List<Record> records : d2Records) {
			System.out.println(records.getFirst().getTransactionType() + ":");
			printHeadings();
			for (Record record : records) {
				printTextRecord(record);
			}
		}
		System.out.println(); // For formatting
	}
	
	public static void printTextRecord(Record r) {
		System.out.printf("%10s %20s %10.2f %14s %14s %20s %20s\n", r.getID(), 
				formatDateTime(r.getTransactionDateTiem()), r.getTransactionAmount(), 
				r.getAccountNo(), r.getAccountName(), r.getTransactionType(), r.getDescription());
	}
	
	public static void printAnalysis(Analysis a) {
		System.out.println("Analysis Result for " + a.getName());
		System.out.printf("Total Spending: %.2f\n", a.getTotalAmt());
		System.out.printf("Average Spenidng per Transaction: %.2f\n", a.getAveragePerTxn());
		System.out.printf("Highest Spending in a single transaction: %.2f\n", a.getMaxTxnAmt());
		System.out.printf("Lowest Spending in a single transaction: %.2f\n",a.getMinTxnAmt());
	}
	
	private static void printHeadings() {
		System.out.printf("%10s %20s %10s %14s %14s %20s %20s\n", "Record ID", "Date/Time", "Amount", "Account No.", "Account Name", "Transasction Type", "Description");
	}
	
	private static String formatDateTime(LocalDateTime dt) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String dtFormatted = dt.format(formatter);
		return dtFormatted;
	}
	
}
