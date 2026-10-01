package com.unifacisa.hospitalTurma2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prontuarios")
@NoArgsConstructor
@Getter
@Setter
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProntuario;
    private String historico;
    private String descricao;

    @OneToOne
    @JoinColumn(name = "paciente_id", unique = true)
    @JsonIgnoreProperties({"consultas", "prontuario"})
    private Paciente paciente;
}

