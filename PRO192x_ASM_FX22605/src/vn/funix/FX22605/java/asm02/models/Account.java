package vn.funix.FX22605.java.asm02.models;

import java.text.DecimalFormat;

public class Account {
    private String accountNumber;
    private double balance;
    private String report;
    public Account() {
    }

    

    public Account(String accountNumber, double balance, String report) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.report = report;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
    	if(accountNumber.length()==6) {
    		this.accountNumber = accountNumber;
    	}
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String toString() {
    	DecimalFormat decimalFormat = new DecimalFormat("#,###");
    	String formattedNumber = decimalFormat.format(balance);
    	String formattedString = String.format("%-8s | %10s | %19s", accountNumber, report, formattedNumber);
        return formattedString;
    }

    public boolean isPremium(){
        if(balance>=10000000){
            return true;
        }else {
            return false;
        }
    }
}
