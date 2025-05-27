package com.senai.Luiz.Fernando.emprestimo.de.livros.repository;

import com.senai.Luiz.Fernando.emprestimo.de.livros.entity.livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface livrorepository extends JpaRepository<livros, Long> {
}

