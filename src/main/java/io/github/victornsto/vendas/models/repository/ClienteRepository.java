package io.github.victornsto.vendas.models.repository;

import io.github.victornsto.vendas.models.entity.Cliente;
import io.github.victornsto.vendas.models.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query("select s from ServicoPrestado s join s.cliente c where upper(c.nome) like upper(:nome) and MONTH(s.data) = :mes")
    List<ServicoPrestado> findByNomeMes(
            @Param("nome") String nome, @Param("mes") Integer mes);
}
