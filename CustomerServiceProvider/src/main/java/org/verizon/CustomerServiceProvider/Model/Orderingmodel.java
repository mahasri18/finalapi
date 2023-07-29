package org.verizon.CustomerServiceProvider.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Orderingmodel {
	@Id
	private int order_id;
	//@ManyToOne//Many books can be written by author
	//@JoinColumn(name="paln_id")
	private int plan_id;
	public Orderingmodel() {
		//TODO Auto-generated constructor stub
		super();
	}
	
	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

}
