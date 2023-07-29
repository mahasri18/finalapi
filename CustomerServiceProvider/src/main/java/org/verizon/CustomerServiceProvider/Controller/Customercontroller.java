package org.verizon.CustomerServiceProvider.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.verizon.CustomerServiceProvider.Model.Customermodel;
import org.verizon.CustomerServiceProvider.Service.Customerservice;

@RestController
@RequestMapping("/api/customermodel")
public class Customercontroller {
	private Customerservice custservice;
	@Autowired
	public Customercontroller(Customerservice custservice) {
		this.custservice=custservice;
	}
	@RequestMapping("/allcustomer")
	public List<Customermodel>getAllCustomermodels(){
		return custservice.getAllCustomermodels();
	}
	@PostMapping("/insertcustomer")
	public Customermodel createCustomermodel(@RequestBody Customermodel customermodel) {
		return custservice.createCustomermodel(customermodel);
	}
	@PostMapping("/update/{cust_id}")
	public Customermodel updateCustomermodel(@PathVariable Integer cust_id,@RequestBody Customermodel customermodel) {
			return custservice.updateCustomermodel(cust_id,customermodel);
}
}
