package org.verizon.CustomerServiceProvider.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Customermodel {
	@Id
	private int cust_id;

	@ManyToOne //Many books can be written by author
	@JoinColumn(name="order_id")
	private Orderingmodel orderingmodel;
	private String cust_name;
		public Customermodel() {
		//TODO Auto-generated constructor stub
		super();
	}
	public Orderingmodel getOrderingmodel() {
		return orderingmodel;
	}
	public void setOrderingmodel(Orderingmodel orderingmodel) {
		this.orderingmodel = orderingmodel;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
}
