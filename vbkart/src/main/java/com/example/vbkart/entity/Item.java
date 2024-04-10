package com.example.vbkart.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@NamedNativeQuery(name="Item.getItemByDesc",query="Select * from item where description LIKE CONCAT(?1,'%')",resultClass=Item.class)
@Table(name="item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="item_details_id",referencedColumnName = "id")
	private ItemDetails itemDetails;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ItemDetails getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(ItemDetails itemDetails) {
		this.itemDetails = itemDetails;
	}
	
}