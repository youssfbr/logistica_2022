package com.github.youssfbr.logistica.services;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.youssfbr.logistica.domain.model.Cliente;
import com.github.youssfbr.logistica.repositories.IClienteRepository;
import com.github.youssfbr.logistica.services.interfaces.IClienteService;
import com.github.youssfbr.logistica.services.exceptions.EntityNotFoundException;


@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService {
	
	private final IClienteRepository clienteRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {		
		return clienteRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByNome(String nome) {		
		return clienteRepository.findByNomeContaining(nome);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) throws EntityNotFoundException {
		return clienteRepository
				.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Cliente insert(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}
