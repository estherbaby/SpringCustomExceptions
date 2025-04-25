package com.developertest.app.ui.response.model;

import java.util.Date;

public class ErrorMessage {
	private Date timeStamp;
	private String Message;
	
	
	/**
	 * @param timeStamp
	 * @param message
	 */
	public ErrorMessage(Date timeStamp, String message) {
		super();
		this.timeStamp = timeStamp;
		Message = message;
	}
	
	public ErrorMessage() {}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
}
