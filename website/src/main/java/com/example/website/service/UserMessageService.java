package com.example.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.website.domain.SupportUserMessage;
import com.example.website.domain.UserMessage;
@Service
public class UserMessageService implements MessageService {
	@Autowired
	UserMessage usermessage;
	@Override
	public String createMessage(int userId) {
		// TODO Auto-generated method stub
		usermessage.setUserId(userId);
		SupportUserMessage supportUserMessage=(SupportUserMessage)usermessage;
		
		
		return supportUserMessage.getMessage();
	}

}
