package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Especialidad;
@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long>{

}
