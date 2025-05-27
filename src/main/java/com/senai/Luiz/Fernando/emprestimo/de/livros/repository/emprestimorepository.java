package com.senai.Luiz.Fernando.emprestimo.de.livros.repository;

import com.senai.Luiz.Fernando.emprestimo.de.livros.entity.emprestimo;
import com.senai.Luiz.Fernando.emprestimo.de.livros.entity.livros;
import com.senai.Luiz.Fernando.emprestimo.de.livros.entity.usuarios;
import com.senai.Luiz.Fernando.emprestimo.de.livros.entity.StatusEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface emprestimorepository extends JpaRepository<emprestimo, Long> {

    boolean existsByLivroAndStatus(livros livro, StatusEmprestimo status);

    long countByUsuarioAndStatus(usuarios usuario, StatusEmprestimo status);

    List<emprestimo> findByUsuarioAndStatus(usuarios usuario, StatusEmprestimo status);
}

