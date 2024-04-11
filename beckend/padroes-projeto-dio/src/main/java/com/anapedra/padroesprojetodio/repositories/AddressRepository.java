package com.anapedra.padroesprojetodio.repositories;

import com.anapedra.padroesprojetodio.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

}