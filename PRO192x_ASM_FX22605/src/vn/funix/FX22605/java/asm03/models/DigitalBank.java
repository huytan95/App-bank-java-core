package vn.funix.FX22605.java.asm03.models;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import vn.funix.FX22605.java.asm02.models.Account;
import vn.funix.FX22605.java.asm02.models.Bank;
import vn.funix.FX22605.java.asm02.models.Customer;
import vn.funix.FX22605.java.asm02.models.User;

public class DigitalBank extends Bank {
	public void Withdraw(String customerId, String accountNumber, double amount) {
		Customer customer = getCustomerById(customerId);
		if (getListTransactions() == null) {
			setListTransactions(new ArrayList<>());
		}
		if (customer != null) {
			int dem = 0;
			for (Account account : customer.getListAcc()) {
				if (account.getAccountNumber().equals(accountNumber)) {
					boolean bl = false;
					if (account.getReport().equals("SAVINGS")) {
						SavingsAccount savingsAccount = (SavingsAccount) account;
						if (savingsAccount.withdraw(amount)) {
							System.out.println("Rut tien thanh cong");
							savingsAccount.log(amount);
							bl = true; 
						} else {
							System.out.println("So tien rut khong hop le");
						}
					} else {
						LoanAccount loanAccount = (LoanAccount) account;
						if (loanAccount.withdraw(amount)) {
							System.out.println("Rut tien thanh cong");
							bl = true;
							loanAccount.log(amount);
						} else {
							System.out.println("So tien rut khong hop le");
						}
					}
					Transaction transaction = new Transaction();
					transaction.setAccountNumber(accountNumber);
					transaction.setAmount(amount);
					transaction.setTime(new Date());
					if (bl) {
						transaction.setStatus(true);
					} else {
						transaction.setStatus(false);
					}
					getListTransactions().add(transaction);
				} else {
					dem++;
				}
			}
			if (dem == customer.getListAcc().size()) {
				System.out.println("So tai khoan khong dung");
			}
		} else {
			System.out.println("Khach hang chua co tren he thong");
		}
	}

	public Customer getCustomerById(String customerId) {
		for (Customer customer : getListCosCustomer()) {
			if (customer.getUser().getCustomerId().equals(customerId)) {
				return customer;
			}
		}
		return null;
	}

	public boolean addCustomer(String customerId, String name) {
		if (getCustomerById(customerId) == null) {
			Customer customer = new Customer();
			customer.setUser(new User(customerId, name));
			getListCosCustomer().add(customer);
			return true;
		}
		return false;
	}

	public void showTransaction(String accountNumber) {
		if(getListTransactions().size()==0 || getListTransactions().stream().noneMatch(o -> o.getAccountNumber().equals(accountNumber))){
			System.out.println("Tai khoan khong co giao dich");
		}
		for (Transaction transaction : getListTransactions()) {
				if (transaction.getAccountNumber().equals(accountNumber)) {
					if(transaction.getAmount()!=0d) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
						DecimalFormat decimalFormat = new DecimalFormat("#,###");
						System.out.println("NGAY GIAO DICH: \t" + dateFormat.format(transaction.getTime()));
						System.out.println("SO TIEN GIAO DICH: \t" + decimalFormat.format(transaction.getAmount()));
						System.out.println("TRANG THAI: \t \t" + (transaction.isStatus() ? "THANH CONG" : "KHONG THANH CONG"));
						System.out.println("-----------------------------------------------");
					}
				}
			} 
		}
	}
