package com.anapedra.padroesprojetodio.services.impl;

import com.anapedra.padroesprojetodio.model.Client;
import com.anapedra.padroesprojetodio.repositories.ClientRepository;
import com.anapedra.padroesprojetodio.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

	
	
	private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
	public Iterable<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client findById(Long id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.get();
	}

	@Override
	public void insert(Client client) {

	}

	@Override
	public void update(Long id, Client client) {

	}


	@Override
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}

	
}

 
