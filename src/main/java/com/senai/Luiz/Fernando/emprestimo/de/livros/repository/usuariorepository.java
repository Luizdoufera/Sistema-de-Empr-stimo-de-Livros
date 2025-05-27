package com.senai.Luiz.Fernando.emprestimo.de.livros.repository;

import com.senai.Luiz.Fernando.emprestimo.de.livros.entity.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usuariorepository extends JpaRepository<usuarios, Long> {
}
