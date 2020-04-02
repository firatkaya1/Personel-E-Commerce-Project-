package com.kayatech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kayatech.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

	List<Message> findByMessageType(String type);
	
	
}
