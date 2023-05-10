package com.teste.frete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.frete.entity.FreteData;


public interface FreteRepository extends JpaRepository<FreteData, Long> {

}
