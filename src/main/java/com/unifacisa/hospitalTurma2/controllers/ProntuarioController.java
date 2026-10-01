package com.unifacisa.hospitalTurma2.controllers;

import com.unifacisa.hospitalTurma2.entities.Prontuario;
import com.unifacisa.hospitalTurma2.services.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService prontuarioService;

    @PostMapping
    public Prontuario cadastrarProntuario(@RequestBody Prontuario prontuario){
        return prontuarioService.cadastrarProntuario(prontuario);
    }

    @GetMapping
    public List<Prontuario> listarProntuario(){
        return prontuarioService.listarProntuario();
    }
}
