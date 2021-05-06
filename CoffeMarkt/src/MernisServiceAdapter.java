import java.rmi.RemoteException;
import java.time.ZoneId;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService {

	@Override
	public Result CheckIfRealPerson(Customer customer) {
		// TODO Auto-generated method stub
		KPSPublicSoapProxy kpsPublicSoapProxy=new KPSPublicSoapProxy();
		boolean result=true;
		
		try {
			result=kpsPublicSoapProxy.TCKimlikNoDogrula(
				Long.parseLong(customer.getNationalId()), 
				customer.getFirstName().toUpperCase(),
				customer.getLastName().toUpperCase(),
				customer.getDateofBirth());
		}catch(RemoteException e) {
			e.printStackTrace();
		}
		
		if(result) {
			return new Result(true);
		}else {
			return new Result(false,"kimlik doðrulama baþarýsýz");
		}
	}

	@Override
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		
	}

}
