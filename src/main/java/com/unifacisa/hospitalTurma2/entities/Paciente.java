package com.unifacisa.hospitalTurma2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pacientes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPaciente;

    @Column(nullable = false)
    private String nome;
    private String telefone;
    private String endereco;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas = new ArrayList<>();

    @OneToOne(mappedBy = "paciente")
    private Prontuario prontuario;



}
