package com.cisco.cmad.dto;

import java.util.List;

public class ErrorResponse {
	
	String message;
	List<String> detail;
	
	
	public ErrorResponse(String message, List<String> detail) {
		super();
		this.message = message;
		this.detail = detail;
	}
	
	public String getMessage() {
		return message;
	}
	
	public List<String> getDetail() {
		return detail;
	}

	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", detail=" + detail + "]";
	}
	
}
