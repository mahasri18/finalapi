package org.verizon.CustomerServiceProvider.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.verizon.CustomerServiceProvider.Model.Orderingmodel;
import org.verizon.CustomerServiceProvider.Repo.Orderingrepo;

@Service
public class Orderingservice {
	@Autowired
	private final Orderingrepo ordrepo;
public Orderingservice(Orderingrepo ordrepo) {
	this.ordrepo=ordrepo;
}
public List<Orderingmodel>getAllOrderingmodels(){
	return ordrepo.findAll();
}

public Orderingmodel createOrderingmodel(Orderingmodel orderingmodel) {
	return ordrepo.save(orderingmodel);
}
public Orderingmodel updateOrderingmodel(int order_id,Orderingmodel orderingmodel) {
	Orderingmodel existingOrderingmodel=ordrepo.findById(order_id).orElse(null);
	if(existingOrderingmodel!=null) {
		existingOrderingmodel.setOrder_id(orderingmodel.getOrder_id());
		return ordrepo.save(existingOrderingmodel);
	}
	return null;
}
}
