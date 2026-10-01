package com.unifacisa.hospitalTurma2.controllers;

import com.unifacisa.hospitalTurma2.entities.Paciente;
import com.unifacisa.hospitalTurma2.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public Paciente salvar(@RequestBody Paciente paciente){
        return pacienteService.salvarPaciente(paciente);
    }

    @GetMapping
    public List<Paciente> listar(){
        return pacienteService.listarPacientes();
    }
}
