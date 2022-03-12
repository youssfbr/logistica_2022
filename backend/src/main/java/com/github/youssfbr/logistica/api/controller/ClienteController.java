package com.github.youssfbr.logistica.api.controller;

import java.net.URI;
import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.youssfbr.logistica.domain.model.Cliente;
import com.github.youssfbr.logistica.services.interfaces.IClienteService;
import com.github.youssfbr.logistica.services.exceptions.EntityNotFoundException;


@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
	
	private final IClienteService clienteService;
		
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.ok(clienteService.findAll());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cliente>> findByNome(@PathVariable String nome) {
		return ResponseEntity.ok(clienteService.findByNome(nome));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Cliente> findAll(@PathVariable Long id) throws EntityNotFoundException {
		return ResponseEntity.ok(clienteService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente) {

		cliente = clienteService.insert(cliente);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cliente.getId()).toUri();

		return ResponseEntity.created(uri).body(cliente);
	}

	@PutMapping("{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) throws EntityNotFoundException {

		cliente = clienteService.update(id, cliente);

		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws EntityNotFoundException {

		clienteService.delete(id);

		return ResponseEntity.noContent().build();
	}

}
