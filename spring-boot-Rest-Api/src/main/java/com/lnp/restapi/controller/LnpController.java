package com.lnp.restapi.controller;

import com.lnp.restapi.entity.Lnp_Entity_Details;
import com.lnp.restapi.mapper.LnpRequestMapper;
import com.source.restapi.dto.LnpResponse;
import com.lnp.restapi.service.LnpService;
import com.source.restapi.dto.LnpRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lnp")
public class LnpController {

	private static final Logger logger = LogManager.getLogger(LnpController.class);
	@Autowired
	private LnpRequestMapper lnpRequestMapper;
	@Autowired
	private LnpService lnpService;

	@PostMapping(value = "/processLNPRequest", consumes = "application/json", produces = "application/json")
	public LnpResponse handleLnpRequest(@RequestBody LnpRequest lnpRequest) {
		logger.info("Received LNP request: {}", lnpRequest);
		LnpResponse lnpResponse = new LnpResponse();
		List<String> messages = new ArrayList<>();
		try {
			// Validation
			if (lnpRequest.getPhoneNumber() == null) {
				messages.add("Phone Number must not be null");
			} else if (lnpRequest.getPhoneNumber().length() != 10) {
				messages.add("Phone Number must be 10 digits");
			}
			if (lnpRequest.getCustomerId() == null ) {
				messages.add("Customer ID  must not be null");
			}
			if (lnpRequest.getNewServiceProvider() == null) {
				messages.add("New service provider cannot be null");
			}

			if (messages.isEmpty()) {
				Lnp_Entity_Details lnpDetails=lnpRequestMapper.mapLnpDetails(lnpRequest);
				lnpService.createLnpDetails(lnpDetails);
				//lnpService.getServiceProviderId(lnpDetails.getCustomerId());

			} 
			else
			{
				messages.add("Request processing failed.");
				lnpResponse.setRequestStatus("Failed");
				logger.warn("LNP request processing failed: {}", lnpRequest);
			}

			lnpResponse.setMessage(messages);

		} catch (Exception e) {
			messages.add("An error occurred: " + e.getMessage());
			logger.error("Error processing LNP request: ", e);
		} finally {
			lnpResponse.setMessage(messages);
		}

		return lnpResponse;
	}  

}
