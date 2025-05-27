package com.senai.Luiz.Fernando.emprestimo.de.livros.service;

import com.senai.Luiz.Fernando.emprestimo.de.livros.entity.livros;
import com.senai.Luiz.Fernando.emprestimo.de.livros.repository.livrorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class livroservice {

    @Autowired
    private livrorepository livrorepository;

    public List<livros> listarTodos() {
        return livrorepository.findAll();
    }

    public Optional<livros> buscarPorId(Long id) {
        return livrorepository.findById(id);
    }

    public livros salvar(livros livro) {
        return livrorepository.save(livro);
    }

    public livros atualizar(Long id, livros livroAtualizado) {
        livroAtualizado.setIdlivro(id);
        return livrorepository.save(livroAtualizado);
    }

    public void deletar(Long id) {
        livrorepository.deleteById(id);
    }
}
