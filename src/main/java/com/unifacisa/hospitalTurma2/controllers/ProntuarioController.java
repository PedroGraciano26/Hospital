package com.unifacisa.hospitalTurma2.controllers;

import com.unifacisa.hospitalTurma2.entities.Prontuario;
import com.unifacisa.hospitalTurma2.services.ProntuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/{id}")
    public Prontuario atualizar(@PathVariable Integer id, @RequestBody Prontuario prontuario){
        return prontuarioService.atualizarProntuario(id, prontuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        prontuarioService.deletarProntuario(id);
    }
}
