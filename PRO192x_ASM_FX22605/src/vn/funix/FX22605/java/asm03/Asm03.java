package vn.funix.FX22605.java.asm03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vn.funix.FX22605.java.asm02.models.Account;
import vn.funix.FX22605.java.asm02.models.Customer;
import vn.funix.FX22605.java.asm03.models.DigitalBank;
import vn.funix.FX22605.java.asm03.models.LoanAccount;
import vn.funix.FX22605.java.asm03.models.SavingsAccount;

public class Asm03 {
	private static final int EXIT_COMMAND_CODE = 0;
	private static final int EXIT_ERROR_CODE = -1;
	private static final Scanner scanner = new Scanner(System.in);
	private static final DigitalBank activeBank = new DigitalBank();
	private static final String CUSTOMER_ID = "001215000001";
	private static final String CUSTOMER_NAME = "FUNIX";
	
	public static void main(String[] args) {
		activeBank.addCustomer(CUSTOMER_ID, CUSTOMER_NAME);
		int luaChon;
		List<Customer> listCustomers = activeBank.getListCosCustomer();
		do {
			System.out.println("+--------------------------------------------+");
			System.out.println("|      NGAN HANG SO | FX22605@v3.0.0         |");
			System.out.println("+--------------------------------------------+");
			System.out.println("| 1. Thong tin khach hang");
			System.out.println("| 2. Them tai khoan ATM");
			System.out.println("| 3. Them tai khoan tin dung");
			System.out.println("| 4. Rut tien");
			System.out.println("| 5. Lich su giao dich");
			System.out.println("| 0. Thoat");
			System.out.println("+--------------------------------------------+");

			System.out.print("Chon chuc nang: ");
			luaChon = scanner.nextInt();
			scanner.nextLine();
			if(luaChon == 1) {
				System.out.println("Nhap CCCD:");
				String id = scanner.nextLine();
				Customer customer = activeBank.getCustomerById(id);
				if (customer.getListAcc() == null) {
					System.out.println("Khach hang chua co tai khoan");
				} else {
					customer.displayInformation();
				}
			}
			if(luaChon == 2) {
				System.out.println("Nhap CCCD cua khach hang:");
				String id = scanner.nextLine();
				SavingsAccount savingsAccount = new SavingsAccount();
				savingsAccount.setReport("SAVINGS");
				activeBank.addAccount(id,listCustomers,savingsAccount);
			}
			if(luaChon == 3) {
				System.out.println("Nhap CCCD cua khach hang:");
				String id = scanner.nextLine();
				LoanAccount loanAccount = new LoanAccount();
				loanAccount.setReport("LOAN");
				activeBank.addAccount(id,listCustomers,loanAccount);
			}
			if(luaChon == 4) {
				System.out.println("Nhap so CCCD cua khach hang:");
				String CCCD = scanner.nextLine();
				System.out.println("Nhap so tai khoan: ");
				String accountNumber = scanner.nextLine();
				System.out.println("Nhap so tien muon rut: ");
				double amount = scanner.nextDouble();
				activeBank.Withdraw(CCCD, accountNumber, amount);
			}
			if(luaChon == 5) {
				if (activeBank.getListTransactions() == null) {
					activeBank.setListTransactions(new ArrayList<>());
				}
				System.out.println("Nhap so tai khoan can tra cuu: ");
				String accountNumber = scanner.nextLine();
				for (Customer customer : listCustomers) {
					if(customer.getListAcc().stream().anyMatch(item->item.getAccountNumber().equals(accountNumber))) {
						activeBank.showTransaction(accountNumber);
					} else {
						System.out.println("So tai khoan khong ton tai");
					}
				}
			}
			if(luaChon > 5) {
				System.out.println("Lua chon khong hop le, vui long chon lai:");
				luaChon = scanner.nextInt();
			}
		} while (luaChon != 0);
	}
}
