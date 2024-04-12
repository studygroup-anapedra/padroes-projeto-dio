package com.anapedra.padroesprojetodio.repositories;

import com.anapedra.padroesprojetodio.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {


}
