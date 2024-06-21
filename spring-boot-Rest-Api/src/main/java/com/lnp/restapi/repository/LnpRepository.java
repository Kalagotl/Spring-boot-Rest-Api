package com.lnp.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.lnp.restapi.entity.Lnp_Entity_Details;

@Repository
public interface LnpRepository extends CrudRepository<Lnp_Entity_Details, Integer> {
}
