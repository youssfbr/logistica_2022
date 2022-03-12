package com.github.youssfbr.logistica.services.interfaces;

import java.util.List;

import com.github.youssfbr.logistica.domain.model.Cliente;
import com.github.youssfbr.logistica.services.exceptions.EntityNotFoundException;

public interface IClienteService {

	List<Cliente> findAll();
	List<Cliente> findByNome(final String nome);
	Cliente findById(final Long id) throws EntityNotFoundException;
	Cliente insert(final Cliente cliente);
	
}
