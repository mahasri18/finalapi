package org.verizon.CustomerServiceProvider.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.verizon.CustomerServiceProvider.Model.Servicemodel;
import org.verizon.CustomerServiceProvider.Service.Serviceservice;

@RestController
@RequestMapping("/api/servicemodel")

public class Servicecontroller {
	private Serviceservice servservice;
	@Autowired
	public Servicecontroller(Serviceservice servservice) {
		this.servservice=servservice;
	}
	@RequestMapping("/allservice")
	public List<Servicemodel>getAllServicemodels(){
		return servservice.getAllServicemodels();
	}
	@PostMapping("/insertservice")
	public Servicemodel createServicemodel(@RequestBody Servicemodel servicemodel) {
		return servservice.createServicemodel(servicemodel);
	}
	@PostMapping("/update/{service_id}")
	public Servicemodel updateServicemodel(@PathVariable Integer service_id,@RequestBody Servicemodel servicemodel) {
			return servservice.updateServicemodel(service_id,servicemodel);
	}
}
