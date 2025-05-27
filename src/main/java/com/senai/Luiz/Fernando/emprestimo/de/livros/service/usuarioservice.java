package com.senai.Luiz.Fernando.emprestimo.de.livros.service;

import com.senai.Luiz.Fernando.emprestimo.de.livros.entity.usuarios;
import com.senai.Luiz.Fernando.emprestimo.de.livros.repository.usuariorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usuarioservice {

    @Autowired
    private usuariorepository usuariosRepository;

    public List<usuarios> listarTodos() {
        return usuariosRepository.findAll();
    }

    public Optional<usuarios> buscarPorId(Long id) {
        return usuariosRepository.findById(id);
    }

    public usuarios salvar(usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    public usuarios atualizar(Long id, usuarios usuarioAtualizado) {
        usuarioAtualizado.setId(id);
        return usuariosRepository.save(usuarioAtualizado);
    }

    public void deletar(Long id) {
        usuariosRepository.deleteById(id);
    }
}

