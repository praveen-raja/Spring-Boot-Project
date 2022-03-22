package com.countryservice.app.controllers;

public class AddResponse {

	private String message;
	private int id;

	public AddResponse(String message, int id) {
		this.message = message;
		this.id = id;
	}
	
	public AddResponse() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
