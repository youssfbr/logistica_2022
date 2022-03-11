package com.github.youssfbr.logistica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.youssfbr.logistica.domain.model.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>{

}
