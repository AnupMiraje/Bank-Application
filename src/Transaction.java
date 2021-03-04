import java.util.Date;

public class Transaction {
	private Date date;
	private String type;
	private int amount;
	public Transaction(Date date, String type, int amount) {
		super();
		this.date = date;
		this.type = type;
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String toString() {
		return this.type+" : "+this.getDate()+" : "+this.getAmount()+"\n";
	}

}
