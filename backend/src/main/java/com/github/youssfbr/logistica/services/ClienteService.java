package com.github.youssfbr.logistica.services;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.youssfbr.logistica.domain.model.Cliente;
import com.github.youssfbr.logistica.repositories.IClienteRepository;
import com.github.youssfbr.logistica.services.interfaces.IClienteService;
import com.github.youssfbr.logistica.services.exceptions.EntityNotFoundException;
import com.github.youssfbr.logistica.services.exceptions.DatabaseException;
import com.github.youssfbr.logistica.services.exceptions.InternalServerError;


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
	public List<Cliente> findByNome(final String nome) {
		return clienteRepository.findByNomeContaining(nome);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(final Long id) throws EntityNotFoundException { return verifyIfExists(id); }

	@Override
	@Transactional
	public Cliente insert(final Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public Cliente update(final Long id, final Cliente cliente) throws EntityNotFoundException {

		verifyIfExists(id);

		cliente.setId(id);

		return clienteRepository.save(cliente);
	}

	@Override
	public void delete(Long id) throws EntityNotFoundException {
		try {
			clienteRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Não foi possível excluir. Violação de integridade.", HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			throw new InternalServerError("Erro interno. Por favor entrar em contato com o suporte.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Cliente verifyIfExists(final Long id) throws EntityNotFoundException {
		return clienteRepository
				.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(id));
	}

}
