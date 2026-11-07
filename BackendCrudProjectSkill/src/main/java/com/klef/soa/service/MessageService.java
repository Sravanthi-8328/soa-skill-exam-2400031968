package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Message;


public interface MessageService {

	Message addMessage(Message message);
	List<Message> displayAllMessages();
	Message updateMessage(Message message);
	 Message displayMessageById(long id);
	String deleteMessageById(long id);
	 List<Message> displayMessageByName(String name);
	 List<Message> displayMessageByType(String type);
	
}
