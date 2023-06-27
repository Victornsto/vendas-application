package io.github.victornsto.vendas.controller;

import io.github.victornsto.vendas.models.entity.Cliente;
import io.github.victornsto.vendas.models.entity.ServicoPrestado;
import io.github.victornsto.vendas.models.repository.ClienteRepository;
import io.github.victornsto.vendas.models.repository.ServicosPrestadoRepository;
import io.github.victornsto.vendas.rest.dto.ServicoPrestadoDTO;
import io.github.victornsto.vendas.util.BigDecimalConverter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servico-prestado")
//@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class ServicoPrestadoController {
    private final ClienteRepository clienteRepository;
    private final ServicosPrestadoRepository servicosPrestadoRepository;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO dto) {
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        Cliente cliente = clienteRepository
                .findById(dto.getIdCliente())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado!"));
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setPreco(bigDecimalConverter.converter(dto.getPreco()));
        return servicosPrestadoRepository.save(servicoPrestado);
    }

    @GetMapping
    public List<ServicoPrestado> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes) {
        return clienteRepository.findByNomeMes("%" + nome + "%", mes);
    }

}
