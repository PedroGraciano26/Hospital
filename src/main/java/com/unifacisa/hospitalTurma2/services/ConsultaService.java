package com.unifacisa.hospitalTurma2.services;

import com.unifacisa.hospitalTurma2.entities.Consulta;
import com.unifacisa.hospitalTurma2.entities.Exame;
import com.unifacisa.hospitalTurma2.entities.Paciente;
import com.unifacisa.hospitalTurma2.repositories.ConsultaRepository;
import com.unifacisa.hospitalTurma2.repositories.ExameRepository;
import com.unifacisa.hospitalTurma2.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    private ExameRepository exameRepository;
    private PacienteRepository pacienteRepository;

    public Consulta cadastrarConsulta(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultas(){
        return consultaRepository.findAll();
    }

    @Transactional
    public Consulta atualizarConsulta(Integer id, Consulta dados){
        Consulta existente = consultaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta não encontrada"));

        existente.setDataHora(dados.getDataHora());
        existente.setDescricao(dados.getDescricao());

        if (dados.getPaciente() != null) {
            Paciente paciente = pacienteRepository.findById(dados.getPaciente().getIdPaciente())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));
            existente.setPaciente(paciente);
        }

        if (dados.getExames() != null) {
            List<Integer> ids = dados.getExames().stream().map(Exame::getId).toList();
            existente.setExames(new ArrayList<>(exameRepository.findAllById(ids)));
        }

        return consultaRepository.save(existente);
    }

    public void deletarConsulta(Integer id){
        if (!consultaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta não encontrada");
        }
        consultaRepository.deleteById(id);
    }
}