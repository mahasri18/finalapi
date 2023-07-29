package org.verizon.CustomerServiceProvider.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EnterpriseCustmodel {
	@Id
	private int enterprisecust_id;
	@ManyToOne //Many books can be written by author
	@JoinColumn(name="oder_id")
	private Orderingmodel orderingmodel;
	private String enterprisecust_name;
	
	public EnterpriseCustmodel() {
		//TODO Auto-generated constructor stub
		super();
	}
	public Orderingmodel getOrderingmodel() {
		return orderingmodel;
	}
	public void setOrderingmodel(Orderingmodel orderingmodel) {
		this.orderingmodel = orderingmodel;
	}
	public String getEnterprisecust_name() {
		return enterprisecust_name;
	}
	public void setEnterprisecust_name(String enterprisecust_name) {
		this.enterprisecust_name = enterprisecust_name;
	}
	public int getEnterprisecust_id() {
		return enterprisecust_id;
	}
	public void setEnterprisecust_id(int enterprisecust_id) {
		this.enterprisecust_id = enterprisecust_id;
	}
}
