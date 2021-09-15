package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
