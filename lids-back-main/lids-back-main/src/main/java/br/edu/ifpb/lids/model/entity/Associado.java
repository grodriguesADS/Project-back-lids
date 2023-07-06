package br.edu.ifpb.lids.model.entity;

import br.edu.ifpb.lids.model.enums.Sexo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;

@MappedSuperclass
@Data
public abstract class Associado implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String usuario;
    @Column(nullable = false)
    private String matricula;
    @Column(nullable = false)
    private Date dataDeNascimento;
    // @Column(nullable = false)
    private Sexo sexo;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;


}
