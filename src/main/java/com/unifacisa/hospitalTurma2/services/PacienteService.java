package com.unifacisa.hospitalTurma2.services;

import com.unifacisa.hospitalTurma2.entities.Paciente;
import com.unifacisa.hospitalTurma2.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente salvarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarPacientes(){
        return pacienteRepository.findAll();
    }

    public Paciente atualizarPaciente(Integer id, Paciente dados){
        Paciente existente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));

        if (dados.getNome() != null) {
            existente.setNome(dados.getNome());
        }
        if (dados.getTelefone() != null) {
            existente.setTelefone(dados.getTelefone());
        }
        if (dados.getEndereco() != null) {
            existente.setEndereco(dados.getEndereco());
        }
        return pacienteRepository.save(existente);
    }

    @Transactional
    public void deletarPaciente(Integer id){
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));

        if (!paciente.getConsultas().isEmpty() || paciente.getProntuario() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Paciente possui consultas ou prontuário vinculados. Apague-os antes.");
        }

        pacienteRepository.delete(paciente);
    }
}