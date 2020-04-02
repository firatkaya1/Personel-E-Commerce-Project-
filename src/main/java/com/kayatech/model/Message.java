package com.kayatech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "message_type")
	private String messageType;
	
	@Column(name = "product_code")
	private String productCode;
	
	@Column(name = "product_tag")
	private String productTag;
	
	@Column(name = "message_name")
	private String messageName;
	
	@Column(name = "message_from")
	private String messageFROM;
	
	@Column(name = "message_to")
	private String messageTO;
	
	@Column(name = "message_date")
	private String messageDate;
	
	@Column(name = "message_description")
	private String messageDescription;

	public Message() {}

	public Message(long id, String messageType, String productCode, String productTag, String messageName,
			String messageFROM, String messageTO, String messageDate, String messageDescription) {
		super();
		this.id = id;
		this.messageType = messageType;
		this.productCode = productCode;
		this.productTag = productTag;
		this.messageName = messageName;
		this.messageFROM = messageFROM;
		this.messageTO = messageTO;
		this.messageDate = messageDate;
		this.messageDescription = messageDescription;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductTag() {
		return productTag;
	}

	public void setProductTag(String productTag) {
		this.productTag = productTag;
	}

	public String getMessageName() {
		return messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}

	public String getMessageFROM() {
		return messageFROM;
	}

	public void setMessageFROM(String messageFROM) {
		this.messageFROM = messageFROM;
	}

	public String getMessageTO() {
		return messageTO;
	}

	public void setMessageTO(String messageTO) {
		this.messageTO = messageTO;
	}

	public String getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

	public String getMessageDescription() {
		return messageDescription;
	}

	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", messageType=" + messageType + ", productCode=" + productCode + ", productTag="
				+ productTag + ", messageName=" + messageName + ", messageFROM=" + messageFROM + ", messageTO="
				+ messageTO + ", messageDate=" + messageDate + ", messageDescription=" + messageDescription + "]";
	}
	
	
	
	
	
	
	
	
}
