package com.github.youssfbr.logistica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.youssfbr.logistica.domain.model.Cliente;
import com.github.youssfbr.logistica.repositories.IClienteRepository;
import com.github.youssfbr.logistica.services.interfaces.IClienteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService implements IClienteService {
	
	private final IClienteRepository clienteRepository;

	@Override
	public List<Cliente> findAll() {		
		return clienteRepository.findAll();
	}

	@Override
	public Cliente findById(Long id) {		
		return clienteRepository.findById(id).orElseThrow(null);
	}

}
