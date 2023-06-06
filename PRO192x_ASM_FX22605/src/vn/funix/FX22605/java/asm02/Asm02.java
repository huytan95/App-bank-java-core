package vn.funix.FX22605.java.asm02;

import vn.funix.FX22605.java.asm02.models.Account;
import vn.funix.FX22605.java.asm02.models.Bank;
import vn.funix.FX22605.java.asm02.models.Customer;
import vn.funix.FX22605.java.asm02.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Asm02 {
	private static final Bank bank = new Bank();

	public static void main(String[] args) {
		int luaChon;
		List<Customer> listCustomer = bank.getListCosCustomer();

		do {
			System.out.println("+--------------------------------------------+");
			System.out.println("|      NGAN HANG SO | FX22605@v2.0.0         |");
			System.out.println("+--------------------------------------------+");
			System.out.println("| 1. Them khach hang                         |");
			System.out.println("| 2. Them tai khoan cho khach hang           |");
			System.out.println("| 3. Hien thi danh sach khach hang           |");
			System.out.println("| 4. Tim theo CCCD                           |");
			System.out.println("| 5. Tim theo ten khach hang                 |");
			System.out.println("| 0. Thoat                                   |");
			System.out.println("+--------------------------------------------+");

			Scanner sc = new Scanner(System.in);
			System.out.print("Chon chuc nang: ");
			luaChon = sc.nextInt();
			sc.nextLine();

			if (luaChon == 1) {
				System.out.println("Nhap ten khach hang:");
				String name = sc.nextLine();
				User user = new User();
				user.setName(name);
				System.out.println("Nhap so CCCD");
				String id = sc.nextLine();
				Customer customer = new Customer();
				while (id.equals("No") == false) {
					int temp = listCustomer.size();
					for (Customer customer1 : listCustomer) {
						if(customer1.getUser().getCustomerId().equals(id)) {
							temp--;
						} else {
						
						}
					}
					if (temp == listCustomer.size() && user.checkId(id)) {
						user.setCustomerId(id);
						customer.setUser(user);
						listCustomer.add(customer);
						break;
					} else {
						System.out.println("CCCD khong hop le! Vui long nhap lai hoac nhap 'No' de thoat");
						id = sc.nextLine();
					}
				}
			}
			if (luaChon == 2) {
				System.out.println("Nhap CCCD cua khach hang:");
				String id = sc.nextLine();
				Account account = new Account();
				bank.addAccount(id, listCustomer, account);
			}
			if (luaChon == 3) {
				for (Customer customer : listCustomer) {
					customer.displayInformation();
					System.out.println();
				}
			}
			if (luaChon == 4) {
				System.out.println("Nhap CCCD cua khach hang can tim:");
				String CCCD = sc.nextLine();
				bank.searchCustomerByCCCD(CCCD, listCustomer);
			}
			if(luaChon == 5) {
				System.out.println("Nhap ten cua khach hang can tim:");
				String name = sc.nextLine();
				bank.searchCustomerByName(name, listCustomer);
			}
		} while (luaChon != 0);
	}
}
