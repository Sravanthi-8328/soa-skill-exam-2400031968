package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Message;
import com.klef.soa.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageRepository repo;

	@Override
	public Message addMessage(Message message) {
		return repo.save(message);
	}

	@Override
	public List<Message> displayAllMessages() {
		return repo.findAll();
	}

	@Override
	public Message updateMessage(Message message) {
		Optional<Message> optional=repo.findById(message.getMessageId());
		if(optional.isPresent()) {
			Message m=optional.get();
			m.setName(message.getName());
			m.setStatus(message.getStatus());
			m.setType(message.getType());
			m.setLocation(message.getLocation());
			return repo.save(m);
		}
		return null;
	}

	@Override
	public Message displayMessageById(long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public String deleteMessageById(long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Message deleted Successfully";
		}
		return "Message not found";
	}

	@Override
	public List<Message> displayMessageByName(String name) {
		  
		return repo.findByName(name);
	}

	@Override
	public List<Message> displayMessageByType(String type) {
		// TODO Auto-generated method stub
		return repo.findByType(type);
	}
	
	
	

}
