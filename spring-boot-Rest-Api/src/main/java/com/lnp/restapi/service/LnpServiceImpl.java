package com.lnp.restapi.service;

import com.lnp.restapi.entity.Lnp_Entity_Details;
import com.lnp.restapi.repository.LnpRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class LnpServiceImpl implements LnpService {

    private static final Logger logger = LogManager.getLogger(LnpServiceImpl.class);
    
    @Autowired
    private RestTemplate restTemplate;

    public String getServiceProviderId(String customerId) {
        String url = "http://localhost:8080/cust/spid/{customerId}";
        return restTemplate.getForObject(url, String.class, customerId);
    }
    @Autowired
    private LnpRepository lnpRepository;

    @Override
    public Optional<Lnp_Entity_Details> getLnpDetails(int id) {
        logger.debug("Fetching LNP details for ID: {}", id);
        return lnpRepository.findById(id);
    }

    @Override
    public Lnp_Entity_Details createLnpDetails(Lnp_Entity_Details lnpDetails) {
        if (lnpDetails.getPhoneNumber() == null || lnpDetails.getPhoneNumber().isEmpty()) {
            logger.error("Phone number is required");
            throw new IllegalArgumentException("Phone number is required");
        }
        logger.debug("Creating LNP details: {}", lnpDetails);
        return lnpRepository.save(lnpDetails);
    }

    @Override
    public Lnp_Entity_Details updateLnpDetails(int id, Lnp_Entity_Details lnpDetails) {
        logger.debug("Updating LNP details for ID: {}", id);
        Optional<Lnp_Entity_Details> existingLnpDetails = lnpRepository.findById(id);
        if (existingLnpDetails.isPresent()) {
            Lnp_Entity_Details updatedDetails = existingLnpDetails.get();
            updatedDetails.setPhoneNumber(lnpDetails.getPhoneNumber());
            updatedDetails.setCurrentServiceProvider(lnpDetails.getCurrentServiceProvider());
            updatedDetails.setNewServiceProvider(lnpDetails.getNewServiceProvider());
            updatedDetails.setCustomerName(lnpDetails.getCustomerName());
            updatedDetails.setCustomerEmail(lnpDetails.getCustomerEmail());
            updatedDetails.setCustomerAddress(lnpDetails.getCustomerAddress());
            updatedDetails.setRequestStatus(lnpDetails.getRequestStatus());
            updatedDetails.setCustomerId(lnpDetails.getCustomerId());
            updatedDetails.setPortingReason(lnpDetails.getPortingReason());
            updatedDetails.setNotes(lnpDetails.getNotes());
            updatedDetails.setAlternateContactNumber(lnpDetails.getAlternateContactNumber());
            updatedDetails.setTransactionId(lnpDetails.getTransactionId());
            logger.info("LNP details updated successfully for ID: {}", id);
            return lnpRepository.save(updatedDetails);
        } else {
            logger.error("LNP details not found for ID: {}", id);
            throw new RuntimeException("LNP Details not found for id :: " + id);
        }
    }

    @Override
    public void deleteLnpDetails(int id) {
        logger.debug("Deleting LNP details for ID: {}", id);
        lnpRepository.deleteById(id);
        logger.info("LNP details deleted successfully for ID: {}", id);
    }
}
