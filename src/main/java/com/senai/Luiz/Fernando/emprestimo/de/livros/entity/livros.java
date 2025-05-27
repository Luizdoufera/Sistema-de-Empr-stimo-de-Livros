package com.senai.Luiz.Fernando.emprestimo.de.livros.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idlivro;

    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;

    // Get e Set
    public Long getIdlivro(){
        return idlivro;

    }

    public void setIdlivro(Long idlivro){
        this.idlivro = idlivro;

    }

    public String getTitulo(){
        return titulo;

    }

    public void setTitulo(String titulo){
        this.titulo = titulo;

    }

    public String getAutor() {
        return autor;

    }
    public void setAutor(String autor){
        this.autor = autor;

    }

    public String getEditora(){
        return editora;

    }
    public void setEditora(String editora){
        this.editora = editora;

    }

    public int getAnoPublicacao(){
        return anoPublicacao;

    }
    public void setAnoPublicacao(int anoPublicacao){
        this.anoPublicacao = anoPublicacao;

    }
}
