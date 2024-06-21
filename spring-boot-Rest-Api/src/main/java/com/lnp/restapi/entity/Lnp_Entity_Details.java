package com.lnp.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lnp_entity_details")
public class Lnp_Entity_Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Lnp_pk")
    private int lnpPk;

    
    private Long spid;
   
	public Long getSpid() {
		return spid;
	}

	public void setSpid(Long spid) {
		this.spid = spid;
	}

	@Column(name = "phoneNumber")
    private String phoneNumber;
    
    @Column(name = "currentServiceProvider")
    private String currentServiceProvider;

    @Column(name = "newServiceProvider")
    private String newServiceProvider;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "customerEmail")
    private String customerEmail;

    @Column(name = "customerAddress")
    private String customerAddress;

    @Column(name = "requestStatus")
    private String requestStatus;

    @Column(name = "customerId")
    private String customerId;

    @Column(name = "portingReason")
    private String portingReason;

    @Column(name = "notes")
    private String notes;

    @Column(name = "alternateContactNumber")
    private String alternateContactNumber;

    @Column(name = "transactionId")
    private String transactionId;

    // Getters and setters

    public int getLnpPk() {
		return lnpPk;
	}

	public void setLnpPk(int lnpPk) {
		this.lnpPk = lnpPk;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCurrentServiceProvider() {
		return currentServiceProvider;
	}

	public void setCurrentServiceProvider(String currentServiceProvider) {
		this.currentServiceProvider = currentServiceProvider;
	}

	public String getNewServiceProvider() {
		return newServiceProvider;
	}

	public void setNewServiceProvider(String newServiceProvider) {
		this.newServiceProvider = newServiceProvider;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPortingReason() {
		return portingReason;
	}

	public void setPortingReason(String portingReason) {
		this.portingReason = portingReason;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getAlternateContactNumber() {
		return alternateContactNumber;
	}

	public void setAlternateContactNumber(String alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Override
    public String toString() {
        return "Lnp_Entity_Details{" +
                "lnpPk=" + lnpPk +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", currentServiceProvider='" + currentServiceProvider + '\'' +
                ", newServiceProvider='" + newServiceProvider + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", requestStatus='" + requestStatus + '\'' +
                ", customerId='" + customerId + '\'' +
                ", portingReason='" + portingReason + '\'' +
                ", notes='" + notes + '\'' +
                ", alternateContactNumber='" + alternateContactNumber + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }

	
}
