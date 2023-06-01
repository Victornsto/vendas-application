package io.github.victornsto.vendas.models.repository;

import io.github.victornsto.vendas.models.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicosRepository extends JpaRepository<Servico, Integer> {
}
