package com.unifacisa.hospitalTurma2.controllers;

import com.unifacisa.hospitalTurma2.entities.Consulta;
import com.unifacisa.hospitalTurma2.entities.Paciente;
import com.unifacisa.hospitalTurma2.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public Consulta cadastrarConsulta(@RequestBody Consulta consulta){
        return consultaService.cadastrarConsulta(consulta);
    }

    @GetMapping
    public List<Consulta> listarConsultas(){
        return consultaService.listarConsultas();
    }
}