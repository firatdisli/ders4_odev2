

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Customer engin=new Customer(1, "engin", "demiroð", 1985, "28861499108");
		
		CustomerCheckService ccs=new StarbucsCustomerManager(new MernisServiceAdapter());
		
		CustomerCheckService cs=new StarbucsCustomerManager(ccs);
		cs.add(engin);
	}

}
