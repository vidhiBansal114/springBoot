package com.example.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.website.domain.User;
@Service
public class StudentUserService implements UserService {
	@Autowired
	User studentUser;
	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return studentUser;
	}

	@Override
	public int signUp(String name, String gender, String location, String college) {
		// TODO Auto-generated method stub
		boolean isUserCreated=studentUser.createUser(name, gender, location, college);
		if(isUserCreated) {
			return studentUser.saveUser();
		}
		return -1;
	}

}
