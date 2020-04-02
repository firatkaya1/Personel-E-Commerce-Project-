package com.kayatech.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kayatech.enums.MessageType;
import com.kayatech.model.Message;
import com.kayatech.repository.MessageRepository;
import com.kayatech.service.MessageService;

@Service
public class MessageServicesImpl implements MessageService {

	@Autowired
	private final MessageRepository messageRepository;
	
	
	public MessageServicesImpl(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Override
	public List<Message> getAllMessages() {
		return messageRepository.findAll();
	}

	@Override
	public Message addMessage(Message message) {
		
		Message m1 = new Message();
		
		m1.setMessageType(message.getMessageType());
		m1.setProductCode(message.getProductCode());
		m1.setProductTag(message.getProductTag());
		m1.setMessageName(message.getMessageName());
		m1.setMessageFROM(message.getMessageFROM());
		m1.setMessageTO(message.getMessageTO());
		m1.setMessageDate(message.getMessageDate());
		m1.setMessageDescription(message.getMessageDescription());
		
		return messageRepository.save(message);
	}

	@Override
	public void deleteMessage(Long id) {
		messageRepository.deleteById(id);
		
	}

	@Override
	public List<Message> getTypeMessage(MessageType type) {
		return messageRepository.findByMessageType(type.toString());
	}

	@Override
	public Message findById(Long id) {
		return messageRepository.getOne(id);
	}

	@Override
	public Message updateMessage(Message message) {
		
		Message m1 = new Message();
		
		m1.setId(message.getId());
		m1.setMessageType(message.getMessageType());
		m1.setProductCode(message.getProductCode());
		m1.setProductTag(message.getProductTag());
		m1.setMessageName(message.getMessageName());
		m1.setMessageFROM(message.getMessageFROM());
		m1.setMessageTO(message.getMessageTO());
		m1.setMessageDate(message.getMessageDate());
		m1.setMessageDescription(message.getMessageDescription());
		
		return messageRepository.save(m1);
	}

}
