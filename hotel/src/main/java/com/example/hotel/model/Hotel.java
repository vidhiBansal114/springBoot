package com.example.hotel.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class Hotel {
	private String id;
	@Size(min=3)
	private String name;
	private String city;
	@Min(value=1)
	@Max(value=10)
	private long rating;
	public Hotel(String id, String name, String city, long rating) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.rating = rating;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getRating() {
		return rating;
	}

	public void setRating(long rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", city=" + city + ", rating=" + rating + "]";
	}

}
