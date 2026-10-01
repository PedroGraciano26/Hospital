package com.unifacisa.hospitalTurma2.controllers;

import com.unifacisa.hospitalTurma2.entities.Exame;
import com.unifacisa.hospitalTurma2.services.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exames")
public class ExameController {

    @Autowired
    private ExameService exameService;

    @PostMapping
    public Exame cadastrarExame(@RequestBody Exame exame){
        return exameService.cadastrarExame(exame);
    }

    @GetMapping
    public List<Exame> listar(){
        return exameService.listarExames();
    }

}
