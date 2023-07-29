package org.verizon.CustomerServiceProvider.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Servicemodel {
	@Id
	private int service_id;
	@ManyToOne//Many books can be written by author
	@JoinColumn(name="paln_id")
	private Catalogmodel catalogmodel;
	private String provision;
	private String test_qos;
	private String activity;
	
	public Servicemodel() {
		//TODO Auto-generated constructor stub
		super();
	}

	public Catalogmodel getCatalogmodel() {
		return catalogmodel;
	}

	public void setCatalogmodel(Catalogmodel catalogmodel) {
		this.catalogmodel = catalogmodel;
	}

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getProvision() {
		return provision;
	}

	public void setProvision(String provision) {
		this.provision = provision;
	}

	public String getTest_qos() {
		return test_qos;
	}

	public void setTest_qos(String test_qos) {
		this.test_qos = test_qos;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}
}
