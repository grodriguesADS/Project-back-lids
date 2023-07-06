package br.edu.ifpb.lids.model.entity;


import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "coordenador")
public class Coordenador extends Associado {

    private Float cargaHorariaSemanal;
}
