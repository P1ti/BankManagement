import java.util.Scanner;

class BankAccount {
	private String name;
	private int accountWallet;
	Scanner sc = new Scanner(System.in);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void openAccount() {
		System.out.println("Name: ");
		this.name = sc.nextLine();
		System.out.println("Wallet open amount of money: ");
		this.accountWallet = Integer.parseInt(sc.nextLine());
	}
	
	public void deposit(int value) {
		this.accountWallet += value;
	}
	
	public void withdraw(int value) {
		this.accountWallet -= value;
	}
	
	public String toString() {
		return "Name: " + this.name + " | Wallet: " + this.accountWallet + " lei";
	}
}

public class BankManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Open accounts: (type the number of user you want to have) ");
		int accno = Integer.parseInt(sc.nextLine());
		BankAccount acc[] = new BankAccount[accno];
		for (int i = 0; i < accno; i++) {
			acc[i] = new BankAccount();
			acc[i].openAccount();
		}
		int option;
		String inputName;
		boolean result = true;
		do {
			System.out.println(
					"***Welcome to your bank management account*** \nPlease select an option from the following:");
			System.out.println("1. Check account \n2. Deposit \n3. Withdraw \n4. Exit");
			option = Integer.parseInt(sc.nextLine());
			switch (option) {
				case 1:
					System.out.println("Type your name: ");
					inputName = sc.nextLine();
					for (int i = 0; i < accno; i++) {
						if (acc[i].getName().equals(inputName)) {
							System.out.println(acc[i]);
							result = true;
						} else {
							result = false;
						}
					}
					if (result == false) {
						System.out.println("You have no bank account");
						break;
					}
					break;
				case 2:
					System.out.println("Type your name: ");
					inputName = sc.nextLine();
					for (int i = 0; i < accno; i++) {
						if (acc[i].getName().equals(inputName)) {
							System.out.println("Type the amount of money you want to deposit: ");
							int amount = Integer.parseInt(sc.nextLine());
							acc[i].deposit(amount);
							result = true;
						} else {
							result = false;
						}
					}
					if (result == false) {
						System.out.println("You have no bank account");
						break;
					}
					break;
				case 3:
					System.out.println("Type your name: ");
					inputName = sc.nextLine();
					for (int i = 0; i < accno; i++) {
						if (acc[i].getName().equals(inputName)) {
							System.out.println("Type the amount of money you want to withdraw: ");
							int amount = Integer.parseInt(sc.nextLine());
							acc[i].withdraw(amount);
							result = true;
						} else {
							result = false;
						}
					}
					if (result == false) {
						System.out.println("You have no bank account");
						break;
					}
					break;
				case 4:
					System.out.println("Have a good day!");
					break;
			}
		} while (option != 4);
	}
}
