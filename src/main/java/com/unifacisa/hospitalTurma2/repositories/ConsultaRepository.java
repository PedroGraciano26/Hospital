package com.unifacisa.hospitalTurma2.repositories;

import com.unifacisa.hospitalTurma2.entities.Consulta;
import com.unifacisa.hospitalTurma2.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}
