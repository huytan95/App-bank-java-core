package vn.funix.FX22605.java.asm03.models;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import vn.funix.FX22605.java.asm02.models.Account;

public class LoanAccount extends Account implements Withdraw, ReportService {
	public static final double LOAN_ACCOUNT_MAX_BALANCE = 100000000;
	public static final double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;
	public static final double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;

	@Override
	public boolean withdraw(double amount) {
		if (isAccepted(amount)) {
			if (isPremium()) {
				setBalance(getBalance() - (amount * (1 + LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE)));
			} else {
				setBalance(getBalance() - (amount * (1 + LOAN_ACCOUNT_WITHDRAW_FEE)));
			}
			
			return true;
		} else {
			return false;
		} 
	}

	@Override
	public boolean isAccepted(double amount) {
		double fee;
		if (isPremium()) {
			fee = LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE;
		} else {
			fee = LOAN_ACCOUNT_WITHDRAW_FEE;
		}
		if (amount>0 && (amount * (1 + fee)) < (getBalance() - 50000) && amount < LOAN_ACCOUNT_MAX_BALANCE) {
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
		System.out.println("       BIEN LAI GIAO DICH SAVINGS            ");
		System.out.println("NGAY G/D: \t" + dateFormat.format(new Date()));
		System.out.println("ATM ID: \t" + "DIGITAL BANK ATM 2023");
		System.out.println("SO TK: \t\t" + getAccountNumber());
		System.out.println("SO TIEN: \t" + decimalFormat.format(amount) + "d");
		System.out.println("SO DU: \t\t" + decimalFormat.format(getBalance()) + "d");
		System.out.println("PHI + VAT: \t" +decimalFormat.format(amount*(isPremium()?LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE : LOAN_ACCOUNT_WITHDRAW_FEE)) +"d");
		System.out.println("+----------------------------------------------+");
	}

}
