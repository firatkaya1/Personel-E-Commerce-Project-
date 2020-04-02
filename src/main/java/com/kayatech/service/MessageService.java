package com.kayatech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kayatech.enums.MessageType;
import com.kayatech.model.Message;

@Service
public interface MessageService {

	List<Message> getAllMessages();
	
	Message addMessage(Message message);
	
	void deleteMessage(Long id);
	
	List<Message> getTypeMessage(MessageType type);
	
	Message findById(Long id);
	
	Message updateMessage(Message message);
}
