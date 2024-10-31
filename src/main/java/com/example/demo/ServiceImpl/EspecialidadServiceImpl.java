package com.example.demo.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Especialidad;
import com.example.demo.repository.EspecialidadRepository;
import com.example.demo.service.EspecialidadService;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public Especialidad create(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad update(Especialidad especialidado) {
        return especialidadRepository.save(especialidado);
    }

    @Override
    public Optional<Especialidad> read(Long id) {
        return especialidadRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        especialidadRepository.deleteById(id);
    }

    @Override
    public List<Especialidad> readAll() {
        return especialidadRepository.findAll();
    }
}
