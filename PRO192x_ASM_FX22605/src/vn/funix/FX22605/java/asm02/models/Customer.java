package vn.funix.FX22605.java.asm02.models;

import java.text.DecimalFormat;
import java.util.List;

public class Customer {
	private User user;
	private List<Account> listAcc;

	public Customer() {
		super();
	}

	public Customer(User user, List<Account> listAcc) {
		super();
		this.user = user;
		this.listAcc = listAcc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Account> getListAcc() {
		return listAcc;
	}

	public void setListAcc(List<Account> listAcc) {
		this.listAcc = listAcc;
	}

	public boolean checkAcc(Account account, List<Account> lisAccounts) {
		for (Account acc : lisAccounts) {
			if (acc.getAccountNumber().equals(account.getAccountNumber())) {
				return false;
			}
		}
		return true;
	}

	public double getBalance() {
		double sum = 0;
			for (Account ac : listAcc) {
				sum = sum + ac.getBalance();
		}
		return sum;
	}

	public boolean isPremium() {
		int temp = 0;
		for (Account account : listAcc) {
			if (account.isPremium()) {
				temp++;
			}
		}
		if (temp != 0) {
			return true;
		} else {
			return false;
		}
	}

	public void displayInformation() {
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		String formattedNumber = decimalFormat.format(getBalance());
		System.out.println("   "+user.getCustomerId() + "  |\t" + user.getName() + " |" + (isPremium() ? "Premium" : "Normal")
				+ "|  " + formattedNumber);
		int i = 1;
		for (Account acc : listAcc) {
			System.out.println();
			System.out.print(i + "\t" + acc.toString());
			System.out.println();
			i++;
		}
	}

}
