package com.lnp.restapi.mapper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lnp.restapi.entity.Lnp_Entity_Details;
import com.lnp.restapi.service.LnpServiceImpl;
import com.lnp.restapi.util.TransactionIdGenerator;
import com.source.restapi.dto.LnpRequest;

@Component
public class LnpRequestMapper {

    @Autowired
    private LnpServiceImpl lnpServiceImpl;

    private static final Logger logger = Logger.getLogger(LnpRequestMapper.class);

    public Lnp_Entity_Details mapLnpDetails(LnpRequest lnpRequest) {
        Lnp_Entity_Details lnpDetails = new Lnp_Entity_Details();
        
        lnpDetails.setPhoneNumber(lnpRequest.getPhoneNumber());
        lnpDetails.setCurrentServiceProvider(lnpRequest.getCurrentServiceProvider());
        lnpDetails.setNewServiceProvider(lnpRequest.getNewServiceProvider());
        lnpDetails.setCustomerName(lnpRequest.getCustomerName());
        lnpDetails.setCustomerEmail(lnpRequest.getCustomerEmail());
        lnpDetails.setCustomerAddress(lnpRequest.getCustomerAddress());
        lnpDetails.setRequestStatus(lnpRequest.getRequestStatus());
        lnpDetails.setCustomerId(lnpRequest.getCustomerId());
        lnpDetails.setPortingReason(lnpRequest.getPortingReason());
        lnpDetails.setNotes(lnpRequest.getNotes());
        lnpDetails.setAlternateContactNumber(lnpRequest.getAlternateContactNumber());

        // Convert the service provider ID from String to Long
        String spidString = lnpServiceImpl.getServiceProviderId(lnpRequest.getCustomerId());
        Long spid = null;
        if (spidString != null) {
            try {
                spid = Long.parseLong(spidString);
                
            } catch (NumberFormatException e) {
                logger.error("Failed to parse service provider ID: " + spidString, e);
                // Set a default value if needed
               
            }
            
        }
        lnpDetails.setSpid(spid);
        // Extract the phone number from the LnpRequest
        String phoneNumber = lnpRequest.getPhoneNumber();
        
        // Generate and set the transaction ID
        String transactionId = TransactionIdGenerator.generateTransactionId(phoneNumber);
        lnpDetails.setTransactionId(transactionId);
		return lnpDetails;
    }
}
