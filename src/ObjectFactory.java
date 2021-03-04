
public class ObjectFactory {

	public static Bank getBankInstance() {
		String bankName = System.getProperty("bankName");
		
		try {
			Class c = Class.forName(bankName);
			return (Bank) c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
