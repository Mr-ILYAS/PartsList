package com.model;

import javax.persistence.*;

@Entity
@Table(name = "parts")
public class Part {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "needed")
	private int needed;
	
	@Column(name = "quantity")
	private int quantity;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNeeded() {
		return needed;
	}
	
	public void setNeeded(int needed) {
		this.needed = needed;
	}

	public boolean isValid() {
		return name != null && !name.isEmpty();
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Part{" +
				"name='" + name + '\'' +
				", needed=" + needed +
				", quantity=" + quantity +
				'}';
	}
}
