package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Especialidad;

public interface EspecialidadService {
	Especialidad create(Especialidad c);
	Especialidad update(Especialidad c);
	void delete(Long id);
	Optional<Especialidad> read(Long id);
	List<Especialidad> readAll();
}
