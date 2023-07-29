package org.verizon.CustomerServiceProvider.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.verizon.CustomerServiceProvider.Model.Orderingmodel;
import org.verizon.CustomerServiceProvider.Service.Orderingservice;

@RestController
@RequestMapping("/api/orderingmodel")
public class Orderingcontroller {
	private Orderingservice ordservice;
	@Autowired
	public Orderingcontroller(Orderingservice ordservice) {
		this.ordservice=ordservice;
	}
	@RequestMapping("/allordering")
	public List<Orderingmodel>getAllOrderingmodels(){
		return ordservice.getAllOrderingmodels();
	}
	@PostMapping("/insertordering")
	public Orderingmodel createOrderingmodel(@RequestBody Orderingmodel orderingmodel) {
		return ordservice.createOrderingmodel(orderingmodel);
	}
	@PostMapping("/update/{order_id}")
	public Orderingmodel updateOrderingmodel(@PathVariable Integer order_id,@RequestBody Orderingmodel orderingmodel) {
			return ordservice.updateOrderingmodel(order_id,orderingmodel);
	}
}
