package com.source.restapi.dto;

import java.util.List;

public class LnpResponse
{ 
	private String phoneNumber;
	private  List<String> message;
	private String newServiceProvider;
	private int customerId;
	private String requestStatus;
	private String statuscode;
	private String TransactionId;
	public String getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}
	public String getNewServiceProvider() {
		return newServiceProvider;
	}
	public void setNewServiceProvider(String newServiceProvider) {
		this.newServiceProvider = newServiceProvider;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}
}
