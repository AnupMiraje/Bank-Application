import java.util.Scanner;

public class ATM {
	private static Scanner sc = new Scanner(System.in);
	private static Bank bankServer = ObjectFactory.getBankInstance();	
	public static void main(String[] args) {
		showMenu();

	}
	private static void showMenu() {
		while(true) {
			System.out.println("1 OpenAccount ");
			System.out.println("2 Withdraw ");
			System.out.println("3 Deposit ");
			System.out.println("4 Transfer ");
			System.out.println("5 Close Account ");
			System.out.println("6 PrintTransactions ");
			System.out.println("7 Exit ");
			System.out.println("Make a choice");
			int choice = sc.nextInt();
			switch(choice) {
			case 1 : openAccount(); break;
			case 2 : withdraw(); break;
			case 3 : deposit(); break;
			case 4 : transfer(); break;
			case 5 : close(); break;
			case 6 : printTxns(); break;
			case 7 : System.exit(1);
			}
		}
	}
	private static void close() {
		System.out.println("Enter accno");
		int accno = sc.nextInt();
		
		try {
			int newBalance = bankServer.closeAccount(accno);
			System.out.println("Close successful "+newBalance);
		} catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static void printTxns() {
		// TODO Auto-generated method stub
		System.out.println("Enter accno");
		int accno = sc.nextInt();
		System.out.println("Enter No of txns");
		int notxns = sc.nextInt();
		try {
			String transactionDetails = bankServer.printRecentTransaction(accno, notxns);			
			System.out.println(transactionDetails);
		} catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void transfer() {
		System.out.println("Enter accno to debit");
		int accnoFrom = sc.nextInt();
		System.out.println("Enter accno to credit");
		int accnoTo = sc.nextInt();
		System.out.println("Enter amount");
		int amount = sc.nextInt();
		try {
			int newBalance = bankServer.transfer(accnoFrom,accnoTo,amount);
			System.out.println("Deposit successful "+newBalance);
		} catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void deposit() {
		// TODO Auto-generated method stub
		System.out.println("Enter accno");
		int accno = sc.nextInt();
		System.out.println("Enter amount");
		int amount = sc.nextInt();
		try {
			int newBalance = bankServer.deposit(accno, amount);
			System.out.println("Deposit successful "+newBalance);
		} catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void withdraw() {
		System.out.println("Enter accno");
		int accno = sc.nextInt();
		System.out.println("Enter amount");
		int amount = sc.nextInt();
		try {
			int newBalance = bankServer.withdraw(accno, amount);
			System.out.println("Withdraw successful "+newBalance);
		} catch (InsufficientBalanceException | InvalidAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void openAccount() {
		System.out.println("Enter Name");
		String name = sc.next();
		System.out.println("Enter Address");
		String address=sc.next();
		System.out.println("Enter Amount");
		int initialAmount=sc.nextInt();
		try {
			String accno = bankServer.openAccount(name,address,initialAmount);
			System.out.println(accno);
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
