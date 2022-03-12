package com.github.youssfbr.logistica.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.youssfbr.logistica.domain.model.Cliente;
import com.github.youssfbr.logistica.services.interfaces.IClienteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
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
	public ResponseEntity<Cliente> findAll(@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.findById(id));
	}
}
