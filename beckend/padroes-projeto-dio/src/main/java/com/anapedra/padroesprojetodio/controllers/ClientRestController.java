package com.anapedra.padroesprojetodio.controllers;

import com.anapedra.padroesprojetodio.model.Client;
import com.anapedra.padroesprojetodio.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class ClientRestController {


	private final ClientService clientService;
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
	public ResponseEntity<Iterable<Client>> findAll() {
		return ResponseEntity.ok(clientService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> findByIdId(@PathVariable Long id) {
		return ResponseEntity.ok(clientService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client client) {
		clientService.insert(client);
		return ResponseEntity.ok(client);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
		clientService.update(id, client);
		return ResponseEntity.ok(client);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clientService.delete(id);
		return ResponseEntity.ok().build();
	}
}

