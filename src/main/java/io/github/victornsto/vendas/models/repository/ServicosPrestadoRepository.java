package io.github.victornsto.vendas.models.repository;

import io.github.victornsto.vendas.models.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicosPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {
}
