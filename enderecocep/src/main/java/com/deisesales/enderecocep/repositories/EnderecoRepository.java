package com.deisesales.enderecocep.repositories;

import com.deisesales.enderecocep.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
}
