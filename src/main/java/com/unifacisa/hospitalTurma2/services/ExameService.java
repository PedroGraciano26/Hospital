package com.unifacisa.hospitalTurma2.services;

import com.unifacisa.hospitalTurma2.entities.Exame;
import com.unifacisa.hospitalTurma2.repositories.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
