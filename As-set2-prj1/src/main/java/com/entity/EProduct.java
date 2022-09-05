package com.entity;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Map;

@Entity
public class EProduct {
	
	@Id
	private int ID;
	private String name;
	private BigDecimal price;
	private Date dateAdded;

	public EProduct() {

	}

	public int getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setID(int id) {
		this.ID = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setDateAdded(Date date) {
		this.dateAdded = date;
	}

}
