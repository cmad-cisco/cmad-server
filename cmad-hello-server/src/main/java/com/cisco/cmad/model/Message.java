package com.cisco.cmad.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Message {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
