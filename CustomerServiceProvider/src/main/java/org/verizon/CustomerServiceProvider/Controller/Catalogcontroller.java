package org.verizon.CustomerServiceProvider.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.verizon.CustomerServiceProvider.Model.Catalogmodel;
import org.verizon.CustomerServiceProvider.Service.Catalogservice;

@RestController
@RequestMapping("/api/catalogmodel")

public class Catalogcontroller {
	private Catalogservice catservice;
	@Autowired
	public Catalogcontroller(Catalogservice catservice) {
		this.catservice=catservice;
	}
	@RequestMapping("/allcatalog")
	public List<Catalogmodel>getAllCatalogmodels(){
		return catservice.getAllCatalogmodels();
	}
	@PostMapping("/insertcatalog")
	public Catalogmodel createCatalogmodel(@RequestBody Catalogmodel catalogmodel) {
		return catservice.createCatalogmodel(catalogmodel);
	}
	@PostMapping("/update/{paln_id}")
	public Catalogmodel updateCatalogmodel(@PathVariable Integer plan_id,@RequestBody Catalogmodel catalogmodel) {
	
			return catservice.updateCatalogmodel(plan_id,catalogmodel);
	}
	@DeleteMapping("/delete/{plan_id}")
	public void deleteCatalogmodel(@PathVariable Integer plan_id){
		catservice.deleteCatalogmodel(plan_id);
	}
}
