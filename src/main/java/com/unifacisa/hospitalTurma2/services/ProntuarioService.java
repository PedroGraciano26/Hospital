package com.unifacisa.hospitalTurma2.services;

import com.unifacisa.hospitalTurma2.entities.Paciente;
import com.unifacisa.hospitalTurma2.entities.Prontuario;
import com.unifacisa.hospitalTurma2.repositories.PacienteRepository;
import com.unifacisa.hospitalTurma2.repositories.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    public Prontuario cadastrarProntuario(Prontuario prontuario){
        return prontuarioRepository.save(prontuario);
    }

    public List<Prontuario> listarProntuario(){
        return prontuarioRepository.findAll();
    }
}

