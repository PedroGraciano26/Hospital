package com.unifacisa.hospitalTurma2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exame")
@NoArgsConstructor
@Getter
@Setter
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    private String tipo;

    @ManyToMany(mappedBy = "exames")
    @JsonIgnore
    private List<Consulta> consultas = new ArrayList<>();
}
