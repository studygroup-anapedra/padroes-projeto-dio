package com.anapedra.padroesprojetodio.services;

import com.anapedra.padroesprojetodio.model.Client;

public interface ClientService {

	Iterable<Client> findAll();

	Client findById(Long id);

	void insert(Client client);

	void update(Long id, Client client);

	void delete(Long id);

}