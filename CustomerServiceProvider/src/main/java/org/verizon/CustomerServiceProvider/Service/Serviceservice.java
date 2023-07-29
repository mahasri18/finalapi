package org.verizon.CustomerServiceProvider.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.verizon.CustomerServiceProvider.Model.Servicemodel;
import org.verizon.CustomerServiceProvider.Repo.Servicerepo;

@Service
public class Serviceservice {
	@Autowired
	private final Servicerepo servrepo;
public Serviceservice(Servicerepo servrepo) {
	this.servrepo=servrepo;
}
public List<Servicemodel>getAllServicemodels(){
	return servrepo.findAll();
}

public Servicemodel createServicemodel(Servicemodel servicemodel) {
	return servrepo.save(servicemodel);
}
public Servicemodel updateServicemodel(int service_id,Servicemodel servicemodel) {
	Servicemodel existingServicemodel=servrepo.findById(service_id).orElse(null);
	if(existingServicemodel!=null) {
		existingServicemodel.setService_id(servicemodel.getService_id());
		existingServicemodel.setProvision(servicemodel.getProvision());
		existingServicemodel.setActivity(servicemodel.getActivity());
		existingServicemodel.setTest_qos(servicemodel.getTest_qos());
		return servrepo.save(existingServicemodel);
	}
	return null;
}
}
