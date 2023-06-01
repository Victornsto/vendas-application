package io.github.victornsto.vendas;

import io.github.victornsto.vendas.models.entity.Cliente;
import io.github.victornsto.vendas.models.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesApplication {
//	@Bean
//	public CommandLineRunner run(@Autowired ClienteRepository repository) {
//		return args -> {
//			Cliente cliente = Cliente.builder().nome("Victor").cpf("02178684289").build();
//			repository.save(cliente);
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

}
