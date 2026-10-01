package com.unifacisa.hospitalTurma2.services;

import com.unifacisa.hospitalTurma2.entities.Consulta;
import com.unifacisa.hospitalTurma2.entities.Exame;
import com.unifacisa.hospitalTurma2.repositories.ExameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ExameService {

    @Autowired
    private ExameRepository exameRepository;

    public Exame cadastrarExame(Exame exame){
        return exameRepository.save(exame);
    }

    public List<Exame> listarExames(){
        return exameRepository.findAll();
    }

    public Exame atualizarExame(Integer id, Exame dados){
        Exame existente = exameRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Exame não encontrado"));

        if (dados.getNome() != null) {
            existente.setNome(dados.getNome());
        }
        if (dados.getTipo() != null) {
            existente.setTipo(dados.getTipo());
        }
        return exameRepository.save(existente);
    }

    @Transactional
    public void deletarExame(Integer id){
        Exame exame = exameRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Exame não encontrado"));

        for (Consulta consulta : exame.getConsultas()) {
            consulta.getExames().remove(exame);
        }

        exameRepository.delete(exame);
    }
}
