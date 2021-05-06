

public class StarbucsCustomerManager extends BaseCustomerManager implements CustomerCheckService{

private CustomerCheckService customerCheckService;
public StarbucsCustomerManager(CustomerCheckService customerCheckService) {
	// TODO Auto-generated constructor stub
	this.customerCheckService=customerCheckService;
}
	
@Override
public void add(Customer customer) {
	// TODO Auto-generated method stub
	Result result =  CheckServiceUtils.runCheckServices(new Result[] {
			customerCheckService.CheckIfRealPerson(customer)
			});
	
	if(!result.isSuccess()) {
		System.out.println(result.getMessage());
		return;
	}
	
	super.add(customer);
}


@Override
public Result CheckIfRealPerson(Customer customer) {
	return customerCheckService.CheckIfRealPerson(customer);
}
		
	}

	

