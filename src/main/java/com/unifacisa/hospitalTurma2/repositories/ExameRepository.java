package com.unifacisa.hospitalTurma2.repositories;

import com.unifacisa.hospitalTurma2.entities.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer> {
}
