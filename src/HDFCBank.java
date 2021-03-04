import java.util.Collections;
import java.util.List;

public class HDFCBank implements Bank {
	private int accno = 11110;
	private DatabaseHandler objdatabase = new DatabaseHandler();
	
	@Override
	public String openAccount(String name, String address, int amount) throws InsufficientBalanceException {
		if(amount < Bank.MIN_BALANCE)
			throw new InsufficientBalanceException("Min balance required to open Account is "+Bank.MIN_BALANCE);
		
		accno = objdatabase.insertAccount(accno, name, address, amount);
		
		return "HDFC Thanks u for opening acc new accno is " + accno;
	}

	@Override
	public int withdraw(int accno, int amount) throws InsufficientBalanceException, InvalidAccountException {
		if(!objdatabase.searchAccount(accno))
			throw new InvalidAccountException();
		
		int oldBalance = objdatabase.getBalance(accno);
		
		if(oldBalance-amount > Bank.MIN_BALANCE) {
			objdatabase.updateAccount(accno, amount, "DEDIT");
		}
		else {
			throw new InsufficientBalanceException("Min balance requires is " + Bank.MIN_BALANCE);
		}
		return objdatabase.getBalance(accno);
	}

	@Override
	public int deposit(int accno, int amount) throws InvalidAccountException {
		if(!objdatabase.searchAccount(accno))
			throw new InvalidAccountException();
		
		objdatabase.updateAccount(accno, amount, "CREDIT");
		
		return objdatabase.getBalance(accno);
	}

	@Override
	public int transfer(int accfrom, int accto, int amount)
			throws InvalidAccountException, InsufficientBalanceException { 
		if(!objdatabase.searchAccount(accfrom) || !objdatabase.searchAccount(accto))
			throw new InvalidAccountException();
		
		int newbalance = withdraw(accfrom, amount);
		try {
			deposit(accto, amount);
		}
		catch(Exception ex) {
			//obj_database.cancelTransaction();
		}
		return newbalance;
	}

	@Override
	public int closeAccount(int accno) throws InvalidAccountException {
		if(!objdatabase.searchAccount(accno))
			throw new InvalidAccountException();
		
		int balance = objdatabase.getBalance(accno);
		
		objdatabase.deleteAccount(accno);
		
		return balance;
	}

	@Override
	public String printRecentTransaction(int accno, int notxns) throws InvalidAccountException {
		if(!objdatabase.searchAccount(accno))
			throw new InvalidAccountException();
		
		List<Transaction> txns = objdatabase.printLastestTransaction(accno);
		Collections.sort(txns,(txn1,txn2)->{return txn2.getDate().compareTo(txn1.getDate());});
		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i < notxns; i++) {
			builder.append(txns.get(i).toString());
		}
		
		return builder.toString();
	}

}
