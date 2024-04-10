package com.example.website.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.website.repository.DAO;

@Component
public class StudentUser implements User {
	String name,gender,location,college;
	int id;
	@Autowired
	DAO studentUserDAO;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	@Override
	public boolean createUser(String name, String gender, String location, String college) {
		// TODO Auto-generated method stub
		this.name=name;
		this.gender=gender;
		this.location=location;
		this.college=college;
		return true;
	}

	@Override
	public Integer saveUser() {
		// TODO Auto-generated method stub
		System.out.println(this.name);
		return studentUserDAO.save(this);
	}

}
