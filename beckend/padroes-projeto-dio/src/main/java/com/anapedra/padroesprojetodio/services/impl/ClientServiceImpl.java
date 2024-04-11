package com.anapedra.padroesprojetodio.services.impl;

import com.anapedra.padroesprojetodio.model.Address;
import com.anapedra.padroesprojetodio.model.Client;
import com.anapedra.padroesprojetodio.repositories.AddressRepository;
import com.anapedra.padroesprojetodio.repositories.ClientRepository;
import com.anapedra.padroesprojetodio.services.ClientService;


import com.anapedra.padroesprojetodio.services.ViaCepService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{


	private final ViaCepService viaCepService;
	private final ClientRepository clientRepository;
	private final AddressRepository addressRepository;

    public ClientServiceImpl(ViaCepService viaCepService, ClientRepository clientRepository, AddressRepository addressRepository) {
        this.viaCepService = viaCepService;
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
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
		saveClientMitCep(client);

	}

	@Override
	public void update(Long id, Client client) {
		Optional<Client> cl = clientRepository.findById(id);
		if (cl.isPresent()) {
			saveClientMitCep(client);
		}

	}




	@Override
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}



	private void saveClientMitCep(Client client) {
		String cep = client.getAddress().getCep();
		Address address = addressRepository.findById(cep).orElseGet(() -> {
			Address newAddress = viaCepService.consultCep(cep);
			addressRepository.save(newAddress);
			return newAddress;
		});
		client.setAddress(address);
		clientRepository.save(client);
	}

	
}

