package vn.funix.FX22605.java.asm03.models;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import vn.funix.FX22605.java.asm02.models.Account;

public class SavingsAccount extends Account implements Withdraw,ReportService {
	public static final double SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;

	@Override
	public boolean withdraw(double amount) {
		if (isAccepted(amount)) {
			setBalance(getBalance() - (amount));
			return true;
		} else {
			return false;
		}
	} 

	@Override
	public boolean isAccepted(double amount) {
		if (amount > 0 && (amount) < (getBalance() - 50000) && amount <= SAVINGS_ACCOUNT_MAX_WITHDRAW) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void log(double amount) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		System.out.println("+----------------------------------------------+");
		System.out.println("       BIEN LAI GIAO DICH SAVINGS           ");
		System.out.println("NGAY G/D: \t"+dateFormat.format(new Date()));
		System.out.println("ATM ID: \t"+ "DIGITAL BANK ATM 2023");
		System.out.println("SO TK: \t\t"+getAccountNumber());
		System.out.println("SO TIEN: \t"+decimalFormat.format(amount)+"d");
		System.out.println("SO DU: \t\t"+decimalFormat.format(getBalance())+"d");
		System.out.println("PHI + VAT: \t"+"0.00d");
		System.out.println("+----------------------------------------------+");
	}
}
