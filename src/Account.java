import java.util.ArrayList;
import java.util.List;

public class Account {
	private String name;
	private String address;
	private int balance;
	private int accno;
	private List<Transaction> txns = new ArrayList<>();
	Account(int accno,String name,String address,int balance){
		this.name = name;
		this.address = address;
		this.balance = balance;
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public List<Transaction> getTxns() {
		return txns;
	}
	public void setTxns(List<Transaction> txns) {
		this.txns = txns;
	}
	

}
