package com.example.demo.ServiceImpl;

import com.example.demo.entity.Medico;
import com.example.demo.repository.MedicoRepository;
import com.example.demo.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public Medico create(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public Medico update(Medico medicoo) {
        return medicoRepository.save(medicoo);
    }

    @Override
    public Optional<Medico> read(Long id) {
        return medicoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        medicoRepository.deleteById(id);
    }

    @Override
    public List<Medico> readAll() {
        return medicoRepository.findAll();
    }
}
