package com.senai.Luiz.Fernando.emprestimo.de.livros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@OpenAPIDefinition(
		info = @io.swagger.v3.oas.annotations.info.Info(
				title = "${info.build.name}",
				version = "${info.build.version}",
				description = "${info.app.description}",
				contact = @io.swagger.v3.oas.annotations.info.Contact(
						name = "Time Arquitetura e APIs",
						email = "luizfernandopadua@gmail.com"
				)
		)
)
@SpringBootApplication
public class EmprestimoDeLivrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmprestimoDeLivrosApplication.class, args);
	}
}
