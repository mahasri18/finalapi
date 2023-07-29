package org.verizon.CustomerServiceProvider.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.verizon.CustomerServiceProvider.Model.EnterpriseCustmodel;
import org.verizon.CustomerServiceProvider.Service.EnterpriseCustomerservice;

@RestController
@RequestMapping("/api/enterprisecustomermodel")

public class EnterpriseCustomerController {
	private EnterpriseCustomerservice enterprisecustservice;
	@Autowired
	public EnterpriseCustomerController(EnterpriseCustomerservice enterprisecustservice) {
		this.enterprisecustservice=enterprisecustservice;
	}
	@RequestMapping("/allenterprisecustomer")
	public List<EnterpriseCustmodel>getAllEnterpriseCustomermodels(){
		return enterprisecustservice.getAllEnterpriseCustomermodels();
	}
	@PostMapping("/insertenterprisecustomer")
	public EnterpriseCustmodel createEnterpriseCustomermodel(@RequestBody EnterpriseCustmodel enterprisecustomermodel) {
		return enterprisecustservice.createEnterpriseCustomermodel(enterprisecustomermodel);
	}
	@PostMapping("/update/{enterprisecust_id}")
	public EnterpriseCustmodel updateEnterpriseCustomermodel(@PathVariable Integer enterprisecust_id,@RequestBody EnterpriseCustmodel enterprisecustomermodel) {
			return enterprisecustservice.updateEnterpriseCustomermodel(enterprisecust_id,enterprisecustomermodel);
	}
}
