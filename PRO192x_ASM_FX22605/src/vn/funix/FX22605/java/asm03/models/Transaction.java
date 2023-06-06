package vn.funix.FX22605.java.asm03.models;

import java.util.Date;
import java.util.UUID;

public class Transaction {
	private String id;
	private String accountNumber;
	private Date time;
	private boolean status;
	private double amount;
	
	public Transaction() {
		super();
	}

	public Transaction(String id, String accountNumber, Date time, boolean status, double amount) {
		super();
		this.id = id; 
		this.accountNumber = accountNumber;
		this.time = time;
		this.status = status;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = String.valueOf(UUID.randomUUID());
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
