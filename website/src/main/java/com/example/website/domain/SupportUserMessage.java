package com.example.website.domain;

import org.springframework.stereotype.Component;

import com.example.website.domain.UserMessage;
@Component
public class SupportUserMessage implements UserMessage {
String message;
	@Override
	public void setUserId(int userId) {
		this.message="Welcome "+String.valueOf(userId);
		// TODO Auto-generated method stub

	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage() {
		message=this.message;
	}

}
