package vn.funix.FX22605.java.asm02.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import vn.funix.FX22605.java.asm03.models.Transaction;

public class Bank {
    private  String id;
    private  List<Customer> listCosCustomer;
    private List<Transaction> listTransactions;

    public Bank(String id, List<Customer> listCosCustomer, List<Transaction> listTransactions) {
		super();
		this.id = id;
		this.listCosCustomer = listCosCustomer;
		this.listTransactions = listTransactions;
	}

	public Bank() {
    	this.listCosCustomer = new ArrayList<>();
    	this.id = String.valueOf(UUID.randomUUID());
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Customer> getListCosCustomer() {
		return listCosCustomer;
	}

	public void setListCosCustomer(List<Customer> listCosCustomer) {
		this.listCosCustomer = listCosCustomer;
	}

	public List<Transaction> getListTransactions() {
		return listTransactions;
	}

	public void setListTransactions(List<Transaction> listTransactions) {
		this.listTransactions = listTransactions;
	}

	public boolean isCustomoerIsExisted(String customerId){
    	int temp=0;
        for(Customer customer : listCosCustomer){
            if(customer.getUser().getCustomerId().equals(customerId)){
                temp++;
            }
        }
        if(temp != 0) {
        	return false;
        }
        return true;
    }
    public void addCustomer(Customer newCustomer){
        if(!isCustomoerIsExisted(newCustomer.getUser().getCustomerId())){
            listCosCustomer.add(newCustomer);
        }
    }
    public void addAccount(String id, List<Customer> listCustomer, Account account) {
    	Scanner sc = new Scanner(System.in);
    	int temp=0;
    	while (true) {
			for (Customer customer : listCustomer) {
				if (customer.getUser().getCustomerId().equals(id)) {
					List<Account> listAccounts = customer.getListAcc();
					if (listAccounts == null) {
						listAccounts = new ArrayList<>();
					}
					System.out.println("Nhap STK gom 6 chu so:");
					String acc = sc.nextLine();
					Boolean bl1;
					while (true) {
						try {
							Integer.parseInt(acc);
							bl1 = true;
						} catch (NumberFormatException e) {
							bl1 = false;
						}
						if (acc.length() != 6 || bl1 == false) {
							System.out.println("STK khong hop le, vui long nhap lai");
							acc = sc.nextLine();
						}
						int dem = 0;
						for (Account account1 : listAccounts) {
							if(account1.getAccountNumber().equals(acc)) {
								System.out.println("So tai khoan da ton tai, vui long nhap lai");
								acc = sc.nextLine();
							} else {
								dem ++;
							}
						}
						if(dem == listAccounts.size()){
							account.setAccountNumber(acc);
							break;
						}
					}
					System.out.println("Nhap so du: ");
					double balance = sc.nextDouble();
					while (true) {
						if (balance > 50000) {
							account.setBalance(balance);
							break;
						} else {
							System.out.println("So du tai khoan phai lon hon 50.000VND,vui long nhap lai");
							balance = sc.nextDouble();
						}
					}
					Boolean check = customer.checkAcc(account, listAccounts);
					if (check) {
						listAccounts.add(account);
						customer.setListAcc(listAccounts);
					}
				} else {
					temp++;
				}
			}

			if (temp == listCustomer.size()) {
				System.out.println("Khach hang chua co tren he thong, vui long nhap lai CCCD!");
				id = sc.nextLine();
			} else {
				break;
			}
		}
    }
    public void searchCustomerByCCCD(String CCCD, List<Customer> listCustomer) {
    	Scanner sc = new Scanner(System.in);
    	while (true) {
			int temp =0;
			for (Customer customer : listCustomer) {
				if (customer.getUser().getCustomerId().equals(CCCD)) {
					if(customer.getListAcc()== null || customer.getListAcc().size() == 0) {
						System.out.println("Khach hang chua co tai khoan");
						break;
					}
					System.out.println("Thong tin khach hang can tim:");
					customer.displayInformation();
					break;
				} else {
					temp ++;
				}
			}
			if(temp == listCustomer.size()) {
				System.out.println("CCCD khong trung khop, vui long nhap lai:");
				CCCD = sc.nextLine();
			} else {
				break;
			}
		}
    }
    public void searchCustomerByName(String name, List<Customer> listCustomer) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
			int temp=0;
			for (Customer customer : listCustomer) {
				if(customer.getUser().getName().contains(name)) {
					if(customer.getListAcc()== null ) {
						System.out.println("Khach hang chua co tai khoan");
						break;
					}
					System.out.println("Thong tin khach hang can tim:");
					customer.displayInformation();
				} else {
					temp++;
				}
			}
			if(temp==listCustomer.size()) {
				System.out.println("Ten khong trung khop, vui long nhap lai:");
				name = sc.nextLine();
			} else {
				break;
			}
		}
    }
}
