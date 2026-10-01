package com.unifacisa.hospitalTurma2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "consultas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idConsulta;
    private LocalDateTime dataHora;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @JsonIgnore
    private Paciente paciente;


    @ManyToMany
    @JoinTable(
            name= "consultas_exames",
            joinColumns = @JoinColumn(name = "consulta_id"),
            inverseJoinColumns = @JoinColumn(name = "exame_id")
    )
    private List<Exame> exames = new ArrayList<>();

}
