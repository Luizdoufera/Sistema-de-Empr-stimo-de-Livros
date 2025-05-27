package com.senai.Luiz.Fernando.emprestimo.de.livros.service;

import com.senai.Luiz.Fernando.emprestimo.de.livros.entity.emprestimo;
import com.senai.Luiz.Fernando.emprestimo.de.livros.entity.StatusEmprestimo;
import com.senai.Luiz.Fernando.emprestimo.de.livros.entity.livros;
import com.senai.Luiz.Fernando.emprestimo.de.livros.entity.usuarios;
import com.senai.Luiz.Fernando.emprestimo.de.livros.repository.emprestimorepository;
import com.senai.Luiz.Fernando.emprestimo.de.livros.repository.livrorepository;
import com.senai.Luiz.Fernando.emprestimo.de.livros.repository.usuariorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class emprestimoservice {

    @Autowired
    private emprestimorepository emprestimorepository;

    @Autowired
    private livrorepository livrosRepository;

    @Autowired
    private usuariorepository usuariosRepository;

    public List<emprestimo> listarTodos() {
        return emprestimorepository.findAll();
    }

    public Optional<emprestimo> buscarPorId(Long id) {
        return emprestimorepository.findById(id);
    }

    public emprestimo realizarEmprestimo(emprestimo emp) {
        livros livro = livrosRepository.findById(emp.getLivro().getIdlivro())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        usuarios usuario = usuariosRepository.findById(emp.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Regra: um livro só pode estar emprestado por vez
        if (emprestimorepository.existsByLivroAndStatus(livro, StatusEmprestimo.EMPRESTADO)) {
            throw new RuntimeException("Este livro já está emprestado.");
        }

        // Regra: um usuário só pode ter até 3 empréstimos ativos
        long emprestimosAtivos = emprestimorepository.countByUsuarioAndStatus(usuario, StatusEmprestimo.EMPRESTADO);
        if (emprestimosAtivos >= 3) {
            throw new RuntimeException("Usuário já possui 3 livros emprestados.");
        }

        emp.setLivro(livro);
        emp.setUsuario(usuario);
        emp.setDataEmprestimo(LocalDate.now());
        emp.setStatus(StatusEmprestimo.EMPRESTADO);

        return emprestimorepository.save(emp);
    }

    public emprestimo registrarDevolucao(Long id) {
        emprestimo emp = emprestimorepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        emp.setStatus(StatusEmprestimo.DEVOLVIDO);
        return emprestimorepository.save(emp);
    }

    public void deletar(Long id) {
        emprestimorepository.deleteById(id);
    }
}
