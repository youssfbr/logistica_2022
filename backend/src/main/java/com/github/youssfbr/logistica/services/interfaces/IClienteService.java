package com.github.youssfbr.logistica.services.interfaces;

import java.util.List;

import com.github.youssfbr.logistica.domain.model.Cliente;
import com.github.youssfbr.logistica.services.exceptions.EntityNotFoundException;

public interface IClienteService {

	List<Cliente> findAll();
	List<Cliente> findByNome(String nome);
	Cliente findById(Long id) throws EntityNotFoundException;
	Cliente insert(Cliente cliente);
	Cliente update(Long id, Cliente cliente) throws EntityNotFoundException;
	void delete(Long id) throws EntityNotFoundException;

}
