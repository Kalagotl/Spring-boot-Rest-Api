package com.lnp.restapi.service;

import com.lnp.restapi.entity.Lnp_Entity_Details;
import java.util.Optional;

public interface LnpService {
    Optional<Lnp_Entity_Details> getLnpDetails(int id);
    
    Lnp_Entity_Details createLnpDetails(Lnp_Entity_Details lnpDetails);
    
    Lnp_Entity_Details updateLnpDetails(int id, Lnp_Entity_Details lnpDetails);
    
    void deleteLnpDetails(int id);

	String getServiceProviderId(String customerId);
}
