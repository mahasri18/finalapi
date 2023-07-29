package org.verizon.CustomerServiceProvider.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Catalogmodel {
	@Id
	private int plan_id;
	private String plan_name;
	private int price;
	private String duration;
	public Catalogmodel() {
		//TODO Auto-generated constructor stub
		super();
	}
	
	public int getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
}
