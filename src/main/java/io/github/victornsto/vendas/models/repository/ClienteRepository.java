package io.github.victornsto.vendas.models.repository;

import io.github.victornsto.vendas.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
