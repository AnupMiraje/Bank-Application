
public interface Bank {
	int MIN_BALANCE = 1000;
	String openAccount(String name,String address,int amount) throws InsufficientBalanceException;
	int withdraw(int accno, int amount) throws InsufficientBalanceException, InvalidAccountException;
	int deposit(int accno, int amount) throws InvalidAccountException;
	int transfer(int accfrom, int accto, int amount) throws InvalidAccountException, InsufficientBalanceException;
	int closeAccount(int accno) throws InvalidAccountException;
	String printRecentTransaction(int accno, int notxns) throws InvalidAccountException;

}
