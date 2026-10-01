package com.unifacisa.hospitalTurma2.services;

import com.unifacisa.hospitalTurma2.entities.Paciente;
import com.unifacisa.hospitalTurma2.entities.Prontuario;
import com.unifacisa.hospitalTurma2.repositories.PacienteRepository;
import com.unifacisa.hospitalTurma2.repositories.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository prontuarioRepository;
    private PacienteRepository pacienteRepository;

    public Prontuario cadastrarProntuario(Prontuario prontuario){
        return prontuarioRepository.save(prontuario);
    }

    public List<Prontuario> listarProntuario(){
        return prontuarioRepository.findAll();
    }

    public Prontuario atualizarProntuario(Integer id, Prontuario dados){
        Prontuario existente = prontuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prontuário não encontrado"));

        if(dados.getHistorico() != null) {
            existente.setHistorico(dados.getHistorico());
        } else if (dados.getDescricao() != null) {
            existente.setDescricao(dados.getDescricao());
        }
        if (dados.getPaciente() != null) {
            Paciente paciente = pacienteRepository.findById(dados.getPaciente().getIdPaciente())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));
            existente.setPaciente(paciente);
        }

        return prontuarioRepository.save(existente);
    }

    public void deletarProntuario(Integer id){
        if (!prontuarioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prontuário não encontrado");
        }
        prontuarioRepository.deleteById(id);
    }
}

